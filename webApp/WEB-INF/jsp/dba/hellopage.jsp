<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="color: white; background-color: black;">
	<center>
		<form action="delete.html" method="get">
			<c:forEach var="item" items="${message}">
				<c:out
					value="${item.tempName}  --# DBA #--  ${item.tempEmail}" />
				<button name="item" value="${item.tempName}">delete</button>
				<p>
			</c:forEach>
		</form>

		<form action="submit.html" method="get">
			name:<input type="text" name="name" /> <br /> email:<input
				type="text" name="email" /><br />
			<button value="submit" type="submit" style="color: red;">submit</button>
		</form>
	</center>
</body>
</html>