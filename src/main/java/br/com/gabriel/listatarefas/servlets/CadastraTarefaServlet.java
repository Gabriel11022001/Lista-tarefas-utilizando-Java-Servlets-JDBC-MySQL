package br.com.gabriel.listatarefas.servlets;

import java.io.IOException;
import java.time.LocalDate;

import br.com.gabriel.listatarefas.entidades.Tarefa;
import br.com.gabriel.listatarefas.services.TarefaService;
import br.com.gabriel.listatarefas.utils.ValidaFormulario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cadastrar")
public class CadastraTarefaServlet extends HttpServlet {

	private TarefaService tarefaService;
	
	public CadastraTarefaServlet() {
		super();
		this.tarefaService = new TarefaService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher despachadorDeRequisicao = req.getRequestDispatcher("/cadastrar.jsp");
		despachadorDeRequisicao.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resultadoCadastrarTarefa = "";
		try {
			String titulo = req.getParameter("titulo");
			if (ValidaFormulario.validarFormulario(titulo) == false) {
				throw new Exception("Informe o título da tarefa!");
			}
			Tarefa tarefa = new Tarefa();
			tarefa.setTitulo(titulo);
			tarefa.setDataCadastro(LocalDate.now());
			tarefa.setStatus("Em execução");
			this.tarefaService.salvar(tarefa);
			resultadoCadastrarTarefa = "Tarefa cadastrada com sucesso!";
		} catch (Exception e) {
			resultadoCadastrarTarefa = e.getMessage();
			e.printStackTrace();
		}
		RequestDispatcher despachadorDeRequisicao = req.getRequestDispatcher("/cadastrar.jsp");
		req.setAttribute("mensagem_cadastrar_tarefa", resultadoCadastrarTarefa);
		despachadorDeRequisicao.forward(req, resp);
	}
}
