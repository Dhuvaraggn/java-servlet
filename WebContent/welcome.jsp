<!DOCTYPE html>
<html>
  <%@ page import="daopack.*"  %>
  
  <%@ page import="java.sql.*"  %>
 
  <%@ page import="java.util.*"  %>
  
  <%@ page import="servicepack.*"  %>
  <%@ taglib uri="WEB-INF/mytaglib.tld" prefix="ajith" %>
<head>
<meta charset="ISO-8859-1">
<title>WELCome</title>
</head>
<body>
<div >
<div >

	<%@ include file="logout.jsp" %>
<h1> Welcome</h1></div>


<!-- <div style="float:right">
<form action="Servlet" >
<input type="hidden" name="formid" id="formid" value="logout"/>
<input type="submit" value="logout"/>
</form></div></div> -->

<div align="center">
<form action="Servlet;jsessionid=<%=session.getId()%>" >
<input type="hidden" name="formid" id="formid" value="goshop"/>
<h1><%=  session.getAttribute("username")%></h1>
<input type="submit" value="go shopping...">
</form>

</div>
</body>
</html>