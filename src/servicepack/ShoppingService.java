package servicepack;

import java.sql.Date;
import java.util.List;

import daopack.InvoiceTransDTO;

public interface ShoppingService {
	public List <InvoiceTransDTO> getAllById(String invoiceid);
	public int insert(String invoiceid,String itemname,int qty);
	public void insertInvoicem(Date invoicedate,String custname,String invoiceid);
}
