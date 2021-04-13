package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


import daopack.InvoiceTransDAOImpl;
import daopack.InvoiceTransDTO;
import daopack.ItemDAOImpl;
import daopack.ItemDTO;
import servicepack.ItemServiceImpl;
import servicepack.ShoppingServiceImpl;

public class ItemStoreGet extends TagSupport{
	private String invoiceid;

	public final String getInvoiceid() {
		return invoiceid;
	}

	public final void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	@Override
	public int doEndTag() throws JspException
	{System.out.println("storeget");
		JspWriter out=pageContext.getOut();
		ShoppingServiceImpl shopServ = ShoppingServiceImpl.getShopServ();
		shopServ.setInvoiceTransDAO(InvoiceTransDAOImpl.getInvoiceTransDAO());
		List<InvoiceTransDTO> l=shopServ.getAllById(invoiceid);
		ItemServiceImpl itemServ=ItemServiceImpl.getItemServ();
		itemServ.setItemDAO(ItemDAOImpl.getItemDAO());
		List<ItemDTO> litem=itemServ.getAll();
		System.out.println("storeget"+l);
		float total=0;
		try {
			out.println("<h1> ItemName		Quantity		Price/Kilo			Price</h1>	");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(InvoiceTransDTO i:l)
		{
			for(ItemDTO it:litem) {
			try {
				if(i.getItemname().equals(it.getItemname()))
				{
				out.println("<h1>"+ i.getItemname() +"   	"+i.getQty() +"			"+it.getPrice() +"	 		"+it.getPrice()*i.getQty()+"</h1>");
				total+=it.getPrice()*i.getQty();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		try {
			out.println("<h1> sgst:"+total*0.01+"</h1>");

			out.println("<h1> cgst:"+total*0.01+"</h1>");

			out.println("<h1> discount:"+total*0.0025+"</h1>");
			out.println("<h1>total:"+(total+total*0.02-total*0.0025)+"</h1>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doEndTag();
	}

}
