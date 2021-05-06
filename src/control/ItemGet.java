package control;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


import daopack.ItemDAOImpl;
import daopack.ItemDTO;
import servicepack.ItemServiceImpl;

public class ItemGet  extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemtype;
	public int doEndTag() throws JspException
	{
		JspWriter out=pageContext.getOut();
		ItemServiceImpl itemServ=ItemServiceImpl.getItemServ();
		try {
			System.out.print("itemget");
		itemServ.setItemDAO(ItemDAOImpl.getItemDAOImpl());
		List<ItemDTO> l=itemServ.getAllByType(itemtype);
		System.out.print(itemtype);
		System.out.print(l);
		for(ItemDTO it:l){
			System.out.print(it);
			out.println("<div style= \"float:left;padding:0 15px;box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2); transition: 0.3s;width: 20%;height: 40%;\" >");
			out.println("<h1>"+it.getItemname()+"</h1>");

			out.println("<img src=\""+it.getImageurl()+"\" width=\"150px\" height=\"150px\"+></img>");
			out.println("<h1> <input type=\"number\" step=\"1\" value=\"0\" name="+it.getItemname()+"></h1>");
			out.println("<button id="+it.getItemname()+" type=\"button\" onclick=\"plusclick(this)\" >+</button>");
			
	
			
			out.println("<button id="+it.getItemname()+" type=\"button\" onclick=\"minusclick(this)\">-</button>");
			out.println("<h2> Rupees: "+it.getPrice()+"<h2>");
			out.println("</div>");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	public final String getItemtype() {
		return itemtype;
	}
	public final void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
}
