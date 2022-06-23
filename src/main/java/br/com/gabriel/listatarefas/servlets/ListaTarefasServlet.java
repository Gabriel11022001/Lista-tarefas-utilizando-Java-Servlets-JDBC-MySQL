package br.com.gabriel.listatarefas.servlets;

import java.io.IOException;
import java.util.List;

import br.com.gabriel.listatarefas.entidades.Tarefa;
import br.com.gabriel.listatarefas.services.TarefaService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tarefas")
public class ListaTarefasServlet extends HttpServlet {

	private TarefaService tarefaService;
	
	public ListaTarefasServlet() {
		super();
		this.tarefaService = new TarefaService();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resultadoConsultaTodasTarefas = "";
		try {
			 List<Tarefa> tarefas = tarefaService.buscarTodas();
			 resultadoConsultaTodasTarefas = "Tarefas consultadas com sucesso!";
			 req.setAttribute("tarefas", tarefas);
		} catch (Exception e) {
			resultadoConsultaTodasTarefas = e.getMessage();
			e.printStackTrace();
		}
		req.setAttribute("mensagem", resultadoConsultaTodasTarefas);
		RequestDispatcher despachadorDeRequisicao = req.getRequestDispatcher("/tarefas.jsp");
		despachadorDeRequisicao.forward(req, resp);
	}
}
