package br.com.gabriel.listatarefas.servlets;

import java.io.IOException;

import br.com.gabriel.listatarefas.entidades.Tarefa;
import br.com.gabriel.listatarefas.services.TarefaService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {
		"/excluir",
		"/excluir/confirmar"
})
public class ExcluirTarefaServlet extends HttpServlet {

	private TarefaService tarefaService;
	
	public ExcluirTarefaServlet() {
		super();
		this.tarefaService = new TarefaService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String acao = req.getRequestURI();
			if (acao.equals("/lista-tarefas/excluir/confirmar")) {
				this.doDelete(req, resp);
				return;
			}
			String idString = req.getParameter("id");
			if (idString.isEmpty()) {
				throw new Exception();
			}
			int idInt = Integer.parseInt(idString);
			if (idInt <= 0) {
				throw new Exception();
			}
			Tarefa tarefaConsulta = this.tarefaService.buscarPeloId(idInt);
			RequestDispatcher despachadorDeRequisicao = req.getRequestDispatcher("/excluir.jsp");
			req.setAttribute("tarefa", tarefaConsulta);
			despachadorDeRequisicao.forward(req, resp);
		} catch (Exception e) {
			resp.sendRedirect("/lista-tarefas/tarefas");
		}
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			this.tarefaService.remover(id);
		} catch (Exception e) {
		} finally {
			resp.sendRedirect("/lista-tarefas/tarefas");
		}
	}
}
