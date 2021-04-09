<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import="daopack.*"  %>
  
  <%@ page import="java.sql.*"  %>
 
  <%@ page import="java.util.*"  %>
  
  <%@ page import="servicepack.*"  %>
  <%@ taglib uri="WEB-INF/mytaglib.tld" prefix="ajith" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GoShop</title>
</head>
<body>
<h1>Vegetable Shop</h1>
	<form action="Servlet" method="post">
	<input type="hidden" name="formid" value="shopping">
	<input type="hidden" name="shopid" value="shop1">
		<!--  Brinjal:<input type="checkbox" name="brinjal" >
		Potato:<input type="checkbox" name="potato">
		Carrot:<input type="checkbox" name="carrot">
		-->
		<!--  <%
			Connection con=DBUtility.getConnection();
			Statement s=con.createStatement();
			ItemServiceImpl itemServ=ItemServiceImpl.getItemServ();
			itemServ.setItemDAO(ItemDAOImpl.getItemDAOImpl());
			List<ItemDTO> l=itemServ.getAllByType("vegetable");
			for(ItemDTO it:l){
				out.println("<h1>"+it.getItemname()+"</h1>");
				out.println("<h1> <input type=\"number\" name="+it.getItemname()+"></h1>");
				out.println("<h2> Rupees: "+it.getPrice()+"<h2>");
			}
			
		%>-->
		<ajith:getData itemtype="vegetable"/>
		
		<input type="submit" value="Next shop..">
	</form>
	
	<%@ include file="logout.jsp" %>
</body>
</html>
</body>
</html> 