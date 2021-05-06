<!DOCTYPE html>
<html>
<head><%@page import="java.util.ResourceBundle" buffer="8kb" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<title>Login page</title>

</head>
<body>

		<div align="center">
		<h1> Login page</h1>
		<form action="Servlet;jsessionid=<%=session.getId()%>">
		<%

ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
%>
			<input type="hidden" id="formid" name="formid" value="login"/>
			<%= rb.getString("username")%>:
			<input type="text" name="username" id="username" placeholder="enter ur user name" autofocus required>*
			</input>
			<br/>
			<br/>
			
			<%= rb.getString("password")%>:
			<input type="password" name="pass" id="pass" placeholder=" enter ur password" required>
			*</input>
			<br/>
			<br/>
			<input  class="inp" type="submit" value="Login"/>
			
		</form>
		<h6> if u don't have account please register!!!</h6>
			<form action="Servlet;jsessionid=<%=session.getId()%>">
				<input type="hidden" name="formid" value="register">
				<input type="submit" value="Register">
			</form>
			</div>
</body>
</html>