package daopack;

import java.sql.SQLException;
import java.util.List;

public interface InvoiceTransDAO {
	public InvoiceTransDTO findById(Integer invoiceid) throws SQLException;
	public List<InvoiceTransDTO> findAllById(String invoiceid)throws SQLException;
	public List<InvoiceTransDTO> findAll()throws SQLException;
	public int insertInvoicet(InvoiceTransDTO invoicetdto)throws SQLException;
	public int updateInvoicet(InvoiceTransDTO invoicetdto)throws SQLException;
	public int deleteByid(Integer invoiceid)throws SQLException;
} 	
