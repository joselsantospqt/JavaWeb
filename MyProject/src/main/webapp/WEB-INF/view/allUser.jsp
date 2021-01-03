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
<link href="static/fontawasome/css/all.min.css" rel="stylesheet" />
</head>
<body>

	<!-- Editable table -->
	<div class="container center">
		<div class="card">
			<h3
				class="card-header text-center font-weight-bold text-uppercase py-4">Todos
				Usuários</h3>
			<div class="card-body">
				<div id="table" class="table-editable">
					<table
						class="table table-bordered table-responsive-md table-striped text-center">
						<thead>
							<tr>
								<th class="text-center">ID</th>
								<th class="text-center">Username</th>
								<th class="text-center">Nome</th>
								<th class="text-center">Sobrenome</th>
								<th class="text-center">Email</th>
								<th class="text-center">Editar</th>
								<th class="text-center">Remove</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users}">
								<tr>
									<td class="pt-3-half" contenteditable="true">${user.id}</td>
									<td class="pt-3-half" contenteditable="true">${user.username}</td>
									<td class="pt-3-half" contenteditable="true">${user.nome}</td>
									<td class="pt-3-half" contenteditable="true">${user.sobrenome}</td>
									<td class="pt-3-half" contenteditable="true">${user.email}</td>
									<td><span class="table-add mb-3 mr-2"><a
											href="/delete-user?id=${user.id }"
											class="btn btn-rounded btn-sm   text-success"><i
												class="fas fa-plus fa-2x" aria-hidden="true"></i></a></span></td>
									<td><span class="table-remove"><a
											href="/delete-user?id=${user.id }"
											class="btn btn-danger btn-rounded btn-sm my-0">Remove</a></span></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<!--  AQUI INICIA O JS FRAMEWORK -->
	<script src="static/MDB/js/jquery-3.3.1.min.js" type="text/javascript"></script>
	<script src="static/MDB/js/popper.min.js" type="text/javascript"></script>
	<script src="static/MDB/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="static/MDB/js/mdb.min.js" type="text/javascript"></script>
	<script src="static/MDB/lightbox/js/lightbox.js" type="text/javascript"></script>
	<script src="static/fontawasome/js/all.js" type="text/javascript"></script>
</body>
</html>