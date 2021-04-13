package daopack;

import java.sql.SQLException;
import java.util.List;

public interface InvoiceMasterDAO {
	public List<InvoiceMasterDTO> findAllByCust(String custname) throws SQLException;
	public InvoiceMasterDTO findById(Integer invoiceid) throws SQLException;
	public List<InvoiceMasterDTO> findAll()throws SQLException;
	public void insertInvoicem(InvoiceMasterDTO invoicemdto)throws SQLException;
	public int updateInvoicem(InvoiceMasterDTO invoicemdto)throws SQLException;
	public int deleteByid(Integer invoiceid)throws SQLException;
	public int deleteByInvoicem(InvoiceMasterDTO invoicemdto)throws SQLException;
}
