package servicepack;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import daopack.InvoiceMasterDAO;
import daopack.InvoiceMasterDTO;
import daopack.InvoiceTransDAO;
import daopack.InvoiceTransDTO;

public class ShoppingServiceImpl implements ShoppingService,Cloneable{
	private static ShoppingServiceImpl shopServ;
	private InvoiceTransDAO invoiceTransDAO;
	private InvoiceMasterDAO invoiceMasterDAO;
	public final InvoiceMasterDAO getInvoiceMasterDAO() {
		return invoiceMasterDAO;
	}
	public final void setInvoiceMasterDAO(InvoiceMasterDAO invoiceMasterDAO) {
		this.invoiceMasterDAO = invoiceMasterDAO;
	}
	synchronized public static ShoppingServiceImpl getShopServ()
	{
		if(shopServ==null) {
			shopServ=new ShoppingServiceImpl();
			}
		return shopServ.createClone();
	}
	private ShoppingServiceImpl createClone() {
		try {
			return (ShoppingServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public final InvoiceTransDAO getInvoiceTransDAO() {
		return invoiceTransDAO;
	}
	public final void setInvoiceTransDAO(InvoiceTransDAO invoiceTransDAO) {
		this.invoiceTransDAO = invoiceTransDAO;
	}
	@Override
	public List<InvoiceTransDTO> getAllById(String invoiceid) {
		try {
			return (List<InvoiceTransDTO>) invoiceTransDAO.findAllById(invoiceid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int insert(String invoiceid, String itemname, int qty) {
		InvoiceTransDTO invoiceDTO =new InvoiceTransDTO();
		invoiceDTO.setInvoiceid(invoiceid);
		invoiceDTO.setItemname(itemname);
		invoiceDTO.setQty(qty);
		try {
			return invoiceTransDAO.insertInvoicet(invoiceDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public void insertInvoicem(Date invoicedate, String custname, String invoiceid) {
		InvoiceMasterDTO i=new InvoiceMasterDTO();
		i.setCustname(custname);
		i.setInvoicedate(invoicedate);
		i.setInvoiceid(invoiceid);
		try {
			invoiceMasterDAO.insertInvoicem(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
