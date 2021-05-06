<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="float:right;">
<form action="Servlet;jsessionid=<%=session.getId()%>" >
	<input name="formid" type="hidden" value="logout">
	<input type="submit" name="logout" value="logout">
</form>
</div>
</body>
</html>