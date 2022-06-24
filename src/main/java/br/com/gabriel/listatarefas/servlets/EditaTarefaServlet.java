package br.com.gabriel.listatarefas.servlets;

import java.io.IOException;

import br.com.gabriel.listatarefas.entidades.Tarefa;
import br.com.gabriel.listatarefas.services.TarefaService;
import br.com.gabriel.listatarefas.utils.ValidaFormulario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/editar")
public class EditaTarefaServlet extends HttpServlet {

	private TarefaService tarefaService;
	
	public EditaTarefaServlet() {
		super();
		this.tarefaService = new TarefaService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String idTarefaString = req.getParameter("id");
			if (idTarefaString.isEmpty()) {
				throw new Exception();
			}
			int tarefaId = Integer.parseInt(req.getParameter("id"));
			if (tarefaId <= 0) {
				throw new Exception();
			}
			Tarefa tarefa = this.tarefaService.buscarPeloId(tarefaId);
			RequestDispatcher despachadorDeRequisicao = req.getRequestDispatcher("/editar.jsp");
			req.setAttribute("tarefa", tarefa);
			despachadorDeRequisicao.forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect("/lista-tarefas/tarefas");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String titulo = req.getParameter("titulo");
			String status = req.getParameter("status");
			if (ValidaFormulario.validarFormularioAtualizarTarefa(titulo, status) == false) {
				throw new Exception();
			}
			Tarefa tarefaAtualizar = new Tarefa();
			tarefaAtualizar.setId(id);
			tarefaAtualizar.setTitulo(titulo);
			tarefaAtualizar.setStatus(status);
			this.tarefaService.atualizar(tarefaAtualizar);
			resp.sendRedirect("/lista-tarefas/tarefas");
		} catch (Exception e) {
			resp.sendRedirect("/lista-tarefas/tarefas");
		}
	}
}
