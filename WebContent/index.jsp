<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="Servlet;jsessionid=<%=session.getId() %>" >
		<input type="hidden" name="formid" value="lang">
		<select name="languague" id="languague">
			<option name="ta" value="ta">tamil</option>
			<option name="te" value="te">telugu</option> 
			</select>
			<input type="submit" value="login...">
	</form>
</body>
</html>