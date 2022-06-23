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
	<title>Lista de tarefas - Cadastro</title>
</head>
<body>
	<!-- Cabeçalho da página para cadastro de tarefas. -->
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
			<%
				if (request.getAttribute("mensagem_cadastrar_tarefa") != null) {
					String mensagemCadastrarTarefa = (String) request.getAttribute("mensagem_cadastrar_tarefa");
					if (mensagemCadastrarTarefa.equals("Tarefa cadastrada com sucesso!")) { %>
						<div class="alert alert-success mt-2 mb-2" role="alert">
							<%= mensagemCadastrarTarefa %>
						</div>	
					<%
					} else { %>
						<div class="alert alert-danger mt-2 mb-2" role="alert">
							<%= mensagemCadastrarTarefa %>
						</div>		
					<%
					}
				}
			%>
			<h1>Cadastrar tarefa</h1>
			<form action="/lista-tarefas/cadastrar" method="post" class="mt-3 mb-2 row">
				<div class="form-group col-12 col-md-6">
				    <label for="titulo">Título da tarefa</label>
				    <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Digite o título da tarefa...">
				</div>
				<div class="form-group col-12 mt-2">
					<button type="submit" class="btn btn-primary">Salvar</button>
				</div>
			</form>
			<a href="/lista-tarefas/tarefas">Voltar para a listagem de tarefas</a>
		</section>
	</main>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/6edfa41fd4.js" crossorigin="anonymous"></script>
</body>
</html>