<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>You owe <c:out value="${owedGold}"/> gold.</p>
	<form action="/clear" method="POST">
		<input type="submit" value="Reset">
	</form>
</body>
</html>