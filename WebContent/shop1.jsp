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
<script>
	function plusclick(ele)
{ var id=ele.id;
console.log("clicked"+id);
document.getElementsByName(id)[0].stepUp();
}
	function minusclick(ele)
	{ var id=ele.id;
	console.log("clicked"+id);
	if(document.getElementsByName(id)[0].value>0)
		{
	document.getElementsByName(id)[0].stepDown();
	
		}}
</script>
	<%@ include file="logout.jsp" %>
<h1>Vegetable Shop</h1>
	<form action="Servlet;jsessionid=<%=session.getId()%>" method="post">
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
				out.println("<div width=\"25%\" height=\"25%\">");
				out.println("<h1>"+it.getItemname()+"</h1>");
				out.println("<img src=\""+it.getImageurl()+"\" width=\"250\" height=\"150\"></img>");
				out.println("<h1> <input type=\"number\"  value=\"0\" name="+it.getItemname()+"></h1>");
				out.println("<h2> Rupees: "+it.getPrice()+"<h2>");
				out.println("</div>");
			}
			
		%>-->
		<ajith:getData itemtype="vegetable"/>
		
		<div style="right:10px;position:absolute;bottom:10px;">
		<input style="width:100px;height:30px;background-color:rgb(20, 200, 76);" type="submit" value="Next shop >>>">
		</div>
	</form>
	
</body>
</html>
</body>
</html> 