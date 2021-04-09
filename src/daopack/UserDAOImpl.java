package daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import daopack.DBUtility;

public class UserDAOImpl implements UserDAO,Cloneable{
	private static UserDAOImpl  userDAO;
	synchronized public static UserDAOImpl getUserDAOImpl() throws SQLException
	{
		if(userDAO==null)
		{
			userDAO=new UserDAOImpl();
		}
		return userDAO.createClone();
	}
	private UserDAOImpl createClone()
	{
		try
		{
			return (UserDAOImpl)super.clone();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	static Connection con;
	static Statement s;
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
	public UserDAOImpl() throws SQLException
	{
		con=DBUtility.getConnection();
	s=con.createStatement();
	//int rs=s.executeUpdate("create table user (userid int, username varchar(30),password varchar(40),flag int);");
	
	}
	@Override
	public void getById(Integer userid) throws SQLException {
		PreparedStatement ps =con.prepareStatement("select * from user where userid=?;	");
		ps.setInt(1, userid);
		ResultSet rs=ps.executeQuery();
		
	}

	@Override
	public ResultSet getAll() throws SQLException {
		ResultSet rs=s.executeQuery("select * from user;");
		return rs;
	}

	@Override
	public int insert(UserDTO userdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("insert into user values (?,?,?,?);");
		ps.setInt(1, userdto.getUserid());
		ps.setString(2, userdto.getUsername());
		ps.setString(3,userdto.getPassword());
		ps.setInt(4, userdto.getFlag());
		int rs=ps.executeUpdate();
		//System.out.print(rs);
		con.commit();
		ps.close();
		return rs;
	}
	public void setflag(int flag,String username) throws SQLException {
		PreparedStatement ps=con.prepareStatement("update user set flag=? where username=?;");
		ps.setString(2,username);
		ps.setInt(1, flag);
		int rs=ps.executeUpdate();
/*		int rs=s.executeUpdate("UPDATE user SET flag="+flag+" WHERE username="+username+";");
		System.out.print(rs);
	*/	con.commit();
		ps.close();
		
		
	}
	@Override
	public int update(UserDTO userdto) throws SQLException {
	PreparedStatement ps=con.prepareStatement("update user set flag=? where username=?");
	ps.setString(2, userdto.getUsername());
	ps.setInt(1, userdto.getFlag());
	int rs=ps.executeUpdate();
	
	con.commit();
	ps.close();
	return rs;
	}

	@Override
	public int deleteById(Integer userid) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete from user where userid=?");
		ps.setInt(1, userid);
		if(ps.execute()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public int deleteByUser(UserDTO userdto) throws SQLException {
		PreparedStatement ps=con.prepareStatement("delete from cust where custid=?");
		ps.setInt(1, userdto.getUserid());
		if(ps.execute()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	@Override
	public UserDTO findByName(String username) throws SQLException {
		PreparedStatement ps =con.prepareStatement("select * from user where username=?;");
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		//System.out.print(rs);
		UserDTO userdto=new UserDTO();
		if(rs!=null) {
		while(rs.next())
		{	//System.out.print(rs.getString(2)+""+rs.getString(3));
			userdto.setUserid(rs.getInt(1));
			userdto.setUsername(rs.getString(2));
			userdto.setPassword(rs.getString(3));
			userdto.setFlag(rs.getInt(4));
		}
		return userdto;
		}
		return null;
	}

}
