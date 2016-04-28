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
		<p>Done !</p>
		<a href="http://localhost:7007/sprTest"
			style="color: white; border-bottom: 2px;">back</a>
	</center>
	<%
		response.sendRedirect("http://localhost:7007/sprTest/rest/hello.html");
	%>
</body>
</html>