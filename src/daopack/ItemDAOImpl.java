package daopack;
import daopack.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO ,Cloneable{
	private Connection con;
	private Statement s;
	private static ItemDAOImpl itemDAO;
	synchronized public static ItemDAOImpl getItemDAOImpl() throws SQLException
	{
		if(itemDAO==null)
		{
			itemDAO=new ItemDAOImpl();
		}
		return itemDAO.createClone();
	}
	private ItemDAOImpl createClone() {
		try {
			return (ItemDAOImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ItemDAOImpl() throws SQLException
	{
		con=DBUtility.getConnection();
		s=con.createStatement();
		}


	

	@Override
	public int insertItem(ItemDTO itemdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into item value(?,?,?,?)");
		ps.setInt(1, itemdto.getItemid());
		ps.setString(2, itemdto.getItemname());
		ps.setString(3, itemdto.getItemtype());
		ps.setInt(4, itemdto.getPrice());
		int rs=ps.executeUpdate();
		con.commit();
		ps.close();
		return rs;
		
	}

	public static final ItemDAOImpl getItemDAO() {
		return itemDAO;
	}
	public static final void setItemDAO(ItemDAOImpl itemDAO) {
		ItemDAOImpl.itemDAO = itemDAO;
	}
	@Override
	public void updateItem(ItemDTO itemdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("update item set price=? where itemid=?");
		ps.setInt(2, itemdto.getItemid());
		ps.setInt(1, itemdto.getPrice());
		ResultSet rs=ps.executeQuery();
	}

	@Override
	public int deleteItembyid(Integer itemid) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete from item where itemid=?");
		ps.setInt(1, itemid);
		if(ps.execute()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	
	@Override
	public ItemDTO getByName(String itemname) throws SQLException {
		PreparedStatement ps =con.prepareStatement("select * from item where itemname=?");
		ps.setString(1, itemname);
		ResultSet rs=ps.executeQuery();
		return null;
	}
	@Override
	public ItemDTO getById(Integer itemid) throws SQLException {
		PreparedStatement ps =con.prepareStatement("select * from item where itemid=?");
		ps.setInt(1, itemid);
		ResultSet rs=ps.executeQuery();
		return null;
	}
	@Override
	public List<ItemDTO> getAll() throws SQLException {
		ResultSet rs=s.executeQuery("select * from item;");
		List<ItemDTO> l=new ArrayList<>();
		while(rs.next())
		{	ItemDTO i=new ItemDTO();
			i.setItemname(rs.getString(2));
			i.setItemtype(rs.getString(3));
			i.setPrice(rs.getInt(4));
			i.setItemid(rs.getInt(1));
		
			l.add(i);
		}
		return l;
	}
	public List<String> getAllItemName() throws SQLException
	{
		ResultSet rs=s.executeQuery("select itemname from item;");
		List<String> l=new ArrayList<>();
		while(rs.next())
		{
			l.add(rs.getString(1));
		}
		return l;
	}
	@Override
	public List<ItemDTO> getAllByType(String itemtype) throws SQLException {
		PreparedStatement ps =con.prepareStatement("select * from item where itemtype=?");
		ps.setString(1, itemtype);
		ResultSet rs=ps.executeQuery();
		List<ItemDTO> l=new ArrayList<>();
		while(rs.next())
		{
			ItemDTO i=new ItemDTO();
			i.setItemid(rs.getInt(1));
			i.setItemname(rs.getString(2));
			i.setItemtype(rs.getString(3));
			i.setPrice(rs.getInt(4));
			i.setImageurl(rs.getString(5));
			l.add(i);
		}
		return l;
	}

}
