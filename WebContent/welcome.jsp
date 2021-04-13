<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCome</title>
</head>
<body>
<h1> Welcome</h1>

<form action="Servlet;jsessionid=<%=session.getId()%>" >
<input type="hidden" name="formid" id="formid" value="goshop"/>
<h1><%=  session.getAttribute("username")%></h1>
<input type="submit" value="go shopping...">
</form>

<form action="Servlet" >
<input type="hidden" name="formid" id="formid" value="logout"/>
<input type="submit" value="logout"/>
</form>
</body>
</html>