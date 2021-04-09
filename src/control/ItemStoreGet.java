package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


import daopack.InvoiceTransDAOImpl;
import daopack.InvoiceTransDTO;
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
		System.out.println("storeget"+l);
		for(InvoiceTransDTO i:l)
		{
			try {
				out.println("<h1>"+ i.getItemname() +"   "+i.getQty() +"</h1>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return super.doEndTag();
	}

}
