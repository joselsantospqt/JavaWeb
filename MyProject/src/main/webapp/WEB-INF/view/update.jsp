<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bem vindo</title>

<!--  AQUI INICIA O CSS FRAMEWORK -->
<link href="static/MDB/css/bootstrap.min.css" rel="stylesheet" />
<link href="static/MDB/css/mdb.min.css" rel="stylesheet" />
<link href="static/MDB/lightbox/css/lightbox.min.css" />
<link href="static/css/site.css" rel="stylesheet" />
</head>

<body class="backgroundWall">

	<div class="container my-5">

		<!--Grid row-->
		<div class="row d-flex justify-content-center">

			<!-- Material form register -->
			<div class="card">




				<!-- Default form register -->
				<form class="text-center border border-light p-5" method="POST"
					action="edit-user">
					<c:if test="${not empty success }">
						<div class="alert alert-success">
							<c:out value="${success }"></c:out>
						</div>
					</c:if>

					<p class="h4 mb-4">Update Usuário</p>
					<input type="hidden" id="ID" value="${user.id}">

					<!-- UserName -->
					<input type="text" id="usuario" class="form-control mb-4"
						placeholder="Usuário:" name="username" value="${user.username}">

					<div class="form-row mb-4">
						<div class="col">
							<!-- First name -->
							<input type="text" id="nome" class="form-control"
								placeholder="Nome:" name="nome" value="${user.nome}">
						</div>
						<div class="col">
							<!-- Last name -->
							<input type="text" id="sobrenome" class="form-control"
								placeholder="Sobrenome:" name="sobrenome"
								value="${user.sobrenome}">
						</div>
					</div>

					<!-- E-mail -->
					<input type="email" id="email" class="form-control mb-4"
						placeholder="E-mail" name="email" value="${user.email}">


					<!-- Sign up button -->
					<input class="btn btn-info my-4 btn-block" type="submit"
						value="Atualizar"/>

					<hr>
					
					<!-- Sign up button -->
					<a href="/delete-user?id=${user.id}" class="btn btn-info my-4 btn-block">Deletar</a>

					<hr>
					<!-- Sign up button -->
					<a href="/buscar" class="btn btn-info my-4 btn-block">Voltar</a>


				</form>
				<!-- Default form register -->



			</div>
			<!-- Material form register -->

		</div>

	</div>

	<!--  AQUI INICIA O JS FRAMEWORK -->
	<script src="static/MDB/js/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="static/MDB/js/popper.min.js" type="text/javascript"></script>
	<script src="static/MDB/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="static/MDB/js/mdb.min.js" type="text/javascript"></script>
	<script src="static/MDB/lightbox/js/lightbox.js" type="text/javascript"></script>
</body>
</html>