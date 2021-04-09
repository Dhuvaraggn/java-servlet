package daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daopack.DBUtility;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO,Cloneable {
	Connection con;
	Statement s;
	private static InvoiceMasterDAOImpl invoiceMastDAO;
	synchronized public static InvoiceMasterDAOImpl getInvoiceMasterDAO() {
		if(invoiceMastDAO==null)
		{
			invoiceMastDAO=new InvoiceMasterDAOImpl();
		}
		return invoiceMastDAO.createClone();
	}
	private InvoiceMasterDAOImpl createClone()
	{
		try {
			return (InvoiceMasterDAOImpl) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public InvoiceMasterDAOImpl()
	{
		con=DBUtility.getConnection();
		//ResultSet rs=s.executeQuery("create table invoicemaster (invoiceid number ,invoicedate timestamp, custid number, custphoneno number)");
		
	}
	@Override
	public InvoiceMasterDTO findById(Integer invoiceid) throws SQLException {
		PreparedStatement ps =con.prepareStatement("select * from invoicemaster where invoiceid=?;");
		ps.setInt(1, invoiceid);
		ResultSet rs=ps.executeQuery();
		return null;
	}

	@Override
	public List<InvoiceMasterDTO> findAll() throws SQLException {
		ResultSet rs=s.executeQuery("select * from invoicemaster");
		
		return null;
	}

	@Override
	public void insertInvoicem(InvoiceMasterDTO invoicemdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into invoicemaster value(?,?,?)");
		ps.setString(2, invoicemdto.getInvoiceid());
		ps.setDate(1, invoicemdto.getInvoicedate());
		ps.setString(3, invoicemdto.getCustname());
		int rs=ps.executeUpdate();
		con.commit();
		ps.close();
	}

	@Override
	public int updateInvoicem(InvoiceMasterDTO invoicemdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("update invoicemaster set invoicedate=?,custname=? where invoiceid=?");
		ps.setDate(1, invoicemdto.getInvoicedate());
		ps.setString(2, invoicemdto.getCustname());
		ps.setString(3, invoicemdto.getInvoiceid());
		ResultSet rs=ps.executeQuery();
		return 1;
	}

	@Override
	public int deleteByid(Integer invoiceid) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete from invoicemaster where invoiceid=?");
		ps.setInt(1, invoiceid);
		if(ps.execute()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public int deleteByInvoicem(InvoiceMasterDTO invoicemdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete from invoicemaster where invoiceid=?");
		ps.setString(1, invoicemdto.getInvoiceid());
		if(ps.execute()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	@Override
	public List<InvoiceMasterDTO> findAllByCust(String custname) throws SQLException {
		PreparedStatement ps=con.prepareStatement("select * from invoicemaster where custname=?;");
		ps.setString(1, custname);
		ResultSet rs=ps.executeQuery();
		List<InvoiceMasterDTO> l=new ArrayList<>();
		while(rs.next())
		{
			InvoiceMasterDTO i=new InvoiceMasterDTO();
			i.setCustname(rs.getString(3));
			i.setInvoiceid(rs.getString(1));
			i.setInvoicedate(rs.getDate(2));
			l.add(i);
			
		}
		return l;
		
	}

}
