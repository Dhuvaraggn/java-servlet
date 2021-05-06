<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Enumeration" %>
    
  <%@ taglib uri="WEB-INF/mytaglib.tld" prefix="ajith" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!--  <div style="background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHEbO3ykRE6WHx9gVzEkSMKCS3iAQ4wyICmeMoJkpyJrKyLODDTjOWxvxPIja7UJL3xUY&usqp=CAU')"; width="1000" height="250">
	  -->
	  
	<%@ include file="logout.jsp" %>
	 <div align="center"> 
	  <ajith:getStored invoiceid="<%= session.getAttribute(\"invoiceid\").toString() %>"/>
	<form action="Servlet;jsessionid=<%= session.getId()%>">	
		<input type="hidden" name="invoiceid" value=<%= session.getAttribute("invoiceid") %>>
		<input type="hidden" name="formid" value="print">	
	  <input type="submit" value="download invoice pdf" >
	</form>
	</div>
</body>
</html>