<%@page import="br.com.gabriel.listatarefas.entidades.Tarefa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="css/estilos-base.css">
	<link rel="stylesheet" href="css/menu.css">
	<title>Lista de tarefas</title>
</head>
<body>
	<!-- Cabeçalho da página com a listagem de tarefas. -->
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark">
			<a class="navbar-brand" href="#">Lista de tarefas</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#conteudoNavbarSuportado" aria-controls="conteudoNavbarSuportado" aria-expanded="false" aria-label="Alterna navegação">
			  <span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="conteudoNavbarSuportado">
			  <ul class="navbar-nav mr-auto">
				<li class="nav-item active">
				  <a class="nav-link" href="/lista-tarefas/cadastrar">Cadastrar tarefa</a>
				</li>
				<li class="nav-item">
				  <a class="nav-link" href="/lista-tarefas/tarefas">Tarefas</a>
				</li>
			  </ul>
			</div>
		</nav>
	</header>
	<main class="mt-5 mb-5">
		<section class="container">
			<a href="/lista-tarefas/cadastrar" class="btn btn-primary"><i class="fa-solid fa-plus"></i>  Cadastrar tarefa</a>
			<%
				String mensagemConsultarTodasAsTarefasNoBancoDeDados = (String) request.getAttribute("mensagem");
				List<Tarefa> tarefas = null;
				if (mensagemConsultarTodasAsTarefasNoBancoDeDados.equals("Tarefas consultadas com sucesso!")) {
					tarefas = (List<Tarefa>) request.getAttribute("tarefas");
				}
			%>
			<%
				if (mensagemConsultarTodasAsTarefasNoBancoDeDados.equals("Tarefas consultadas com sucesso!")) { %>
					<table class="table table-striped table-responsive mt-3">
					  <thead>
					    <tr>
					      <th scope="col">Título da tarefa</th>
					      <th scope="col">Status</th>
					      <th scope="col">Data de cadastro</th>
					      <th scope="col">Ações</th>
					    </tr>
					  </thead>
					  <tbody>
					  	<%
					  		for (Tarefa tarefa : tarefas) { %>
					  			<tr>
							      <th scope="row"><%= tarefa.getTitulo() %></th>
							      <th scope="col"><%= tarefa.getStatus() %></th>
							      <th scope="col"><%= tarefa.getDataCadastro() %></th>
							      <td>
							      	<a href="/lista-tarefas/editar?id=<%= tarefa.getId() %>" class="btn btn-warning"><i class="fa-solid fa-pen"></i>  Editar</a>
							      	<a href="/lista-tarefas/marcar-como-concluida?id=<%= tarefa.getId() %>" class="btn btn-info"><i class="fa-solid fa-clipboard-check"></i>  Marcar como concluida</a>
							      	<a href="/lista-tarefas/excluir?id=<%= tarefa.getId() %>" class="btn btn-danger"><i class="fa-solid fa-trash"></i>  Excluir</a>
							      </td>
							    </tr>
					  		<%
					  		}
					  	%>
					  </tbody>
					</table>
				<%
				} else { %>
					<div class="alert alert-danger mt-3" role="alert">
						<%= mensagemConsultarTodasAsTarefasNoBancoDeDados %>
					</div>
				<%
				}
			%>
		</section>
	</main>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/6edfa41fd4.js" crossorigin="anonymous"></script>
</body>
</html>