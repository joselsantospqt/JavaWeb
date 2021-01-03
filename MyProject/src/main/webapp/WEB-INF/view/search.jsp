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
				<form class="text-center border border-light p-5" method="GET"
					action="show-User">
					<c:if test="${not empty error }">
						<div class="alert alert-danger">
							<c:out value="${error }"></c:out>
						</div>
					</c:if>

					<p class="h4 mb-4 pl-5 pr-5">    Buscar    </p>

					<!-- UserName -->
					<input type="text" id="ID" class="form-control mb-4"
						placeholder="ID:" name="id" value="${user.id}">

					<hr>
					<!-- Sign up button -->
					<input type="submit" class="btn btn-info my-4 btn-block" value="Buscar">


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