<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- display the gold from session -->
	<div>
		<h1 style="display:inline-block">Your Gold: </h1>
		<h1 style="border: 2px solid black; display:inline-block"><c:out value="${gold}"/></h1>
	</div>
	<div class="container fluid">
		<div class="row">
			<div class="col-sm-3">
				<div class="box text-center d-flex justify-content-center" style="border: 2px solid black; margin: 20px; width: 220px;">
					<form action="/farm" method="POST">
						<h3 style="margin-top: 20px;">Farm</h3>
						<p>(earns 10-20 gold)</p>
						<input style="margin-bottom: 25px; background-color:white; box-shadow: 5px 5px" type="submit" value="Find Gold!">
					</form>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="box text-center d-flex justify-content-center" style="border: 2px solid black; margin: 20px; width:220px;">
					<form action="/cave" method="POST">
						<h3 style="margin-top: 20px;">Cave</h3>
						<p>(earns 5-10 gold)</p>
						<input style="margin-bottom: 25px; background-color:white; box-shadow: 5px 5px" type="submit" value="Find Gold!">
					</form>
				</div>
			</div>
			<div class="col-sm-3" >
				<div class="box text-center d-flex justify-content-center" style="border: 2px solid black; margin: 20px; width:220px;">
					<form action="/house" method="POST">
						<h3 style="margin-top: 20px;">House</h3>
						<p>(earns 2-5 gold)</p>
						<input style="margin-bottom: 25px; background-color:white; box-shadow: 5px 5px" type="submit" value="Find Gold!">
					</form>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="box text-center d-flex justify-content-center" style="border: 2px solid black; margin: 20px; width: 220px;">
					<form action="/quest" method="POST">
						<h3 style="margin-top: 20px;">Quest</h3>
						<p>(earns/takes 0-50 gold)</p>
						<input style="margin-bottom: 25px; background-color:white; box-shadow: 5px 5px" type="submit" value="Find Gold!">
					</form>
				</div>
			</div>
		</div>
	</div>

	<p>Activities:</p>
	<div style="border:2px solid black">
		<c:forEach var="venture" items="${adventurersLog}">
			<c:set var="color" value="${venture.contains('lost') ? 'red' : 'green'}"/>
			<p style="color: ${color};">
				<c:out value="${venture}"></c:out>
			</p>		
		</c:forEach>
	</div>
	
</body>
</html>