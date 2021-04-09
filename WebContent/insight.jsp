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

	 <ajith:getStored invoiceid="<%= session.getAttribute(\"invoiceid\").toString() %>"/>
	<%@ include file="logout.jsp" %>
</body>
</html>