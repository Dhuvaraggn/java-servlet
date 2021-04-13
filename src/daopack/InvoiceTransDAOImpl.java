package daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daopack.DBUtility;

public class InvoiceTransDAOImpl implements InvoiceTransDAO,Cloneable {
	static Connection con;
	static Statement s;
	private static InvoiceTransDAOImpl invoiceDAO;
	synchronized public static InvoiceTransDAOImpl getInvoiceTransDAO()
	{
		if(invoiceDAO==null) {
			try {
				invoiceDAO=new InvoiceTransDAOImpl();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return invoiceDAO.createClone();
	}
	private InvoiceTransDAOImpl createClone() {
		try {
			return (InvoiceTransDAOImpl) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	static 
	{
		con=DBUtility.getConnection();
		try {
			s=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public InvoiceTransDAOImpl() throws SQLException
	{
		con=DBUtility.getConnection();
		s=con.createStatement();
	//	ResultSet rs=s.executeQuery("create table invoicetrans (invoiceid number ,itemid number ,qty number)");
		
	}
	@Override
	public InvoiceTransDTO findById(Integer invoiceid) throws SQLException {
		PreparedStatement ps =con.prepareStatement("select * from invoicetrans where invoiceid=?");
		ps.setInt(1, invoiceid);
		ResultSet rs=ps.executeQuery();
		return null;
	}
	@Override
	public List<InvoiceTransDTO> findAllById(String invoiceid) throws SQLException {
		PreparedStatement ps=con.prepareStatement("select * from invoicetrans where invoiceid=?;");
		ps.setString(1,invoiceid);
		ResultSet rs=ps.executeQuery();
		List<InvoiceTransDTO> l=new ArrayList<>();
		while(rs.next())
		{
			InvoiceTransDTO in=new InvoiceTransDTO();
			in.setInvoiceid(rs.getString(1));
			in.setItemname(rs.getString(2));
			in.setQty(rs.getInt(3));
			l.add(in);
		}
		return l;
	}
	@Override
	public List<InvoiceTransDTO> findAll() throws SQLException {
		ResultSet rs=s.executeQuery("select * from invoicetrans");
		
		return null;
	}
	@Override
	public int insertInvoicet(InvoiceTransDTO invoicetdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into invoicetrans values (?,?,?);");
		ps.setString(1, invoicetdto.getInvoiceid());
		ps.setString(2, invoicetdto.getItemname());
		ps.setInt(3, invoicetdto.getQty());
		int rs=ps.executeUpdate();
		con.commit();
		ps.close();
		return rs;
	}
	@Override
	public int updateInvoicet(InvoiceTransDTO invoicetdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("update invoicetrans set itemid=?,qty=? where invoiceid=?");
		ps.setString(3, invoicetdto.getInvoiceid());
		ps.setString(1, invoicetdto.getItemname());
		ps.setInt(2, invoicetdto.getQty());
		ResultSet rs=ps.executeQuery();
		return 1;
	}
	@Override
	public int deleteByid(Integer invoiceid) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete from invoicetrans where invoiceid=?");
		ps.setInt(1, invoiceid);
		if(ps.execute()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	}
