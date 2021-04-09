package control;

import java.sql.SQLException;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.InvoiceMasterDAOImpl;
import daopack.InvoiceTransDAOImpl;
import servicepack.PDFService;
import servicepack.PDFServiceImpl;
import servicepack.ShoppingService;
import servicepack.ShoppingServiceImpl;

public class ShoppingAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
		String s=request.getParameter("shopid").toString();
		Enumeration<String> st=request.getParameterNames();
		HttpSession session=request.getSession();
		ShoppingServiceImpl shopServ=ShoppingServiceImpl.getShopServ();
		shopServ.setInvoiceTransDAO(InvoiceTransDAOImpl.getInvoiceTransDAO());
		shopServ.setInvoiceMasterDAO(InvoiceMasterDAOImpl.getInvoiceMasterDAO());
		String id=session.getAttribute("invoiceid").toString();
		while(st.hasMoreElements()) {
			String name=st.nextElement();
			String value=request.getParameter(name);
			if(name.equals("shopid"))
			{
				if(request.getParameter("shopid").equals("shop3"))
				{
					shopServ.insertInvoicem((Date)session.getAttribute("date"), 
							session.getAttribute("invoiceid").toString(),session.getAttribute("username").toString());
					PDFService pdf=PDFServiceImpl.getPDFServ();
					pdf.createPdf(id);
				}
			}
			else if(name.equals("formid"))
			{
			}
			else
			{
			//session.setAttribute(name, value);
			shopServ.insert(id, name, Integer.parseInt(value.toString()));
			}
		}

		return "shopping."+s;
	}

}
