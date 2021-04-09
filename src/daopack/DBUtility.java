package daopack;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class DBUtility {
	public DBUtility() {
		
	}
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	private static Connection con;
	private static String url,username,password;
	static {
		Properties prop=new Properties();
		try {
			/*prop.load(new FileInputStream("dbconfig.properties"));
			username=(String) prop.get("username");
			url=(String) prop.get("url");
			password=(String) prop.get("password");
			String driver=(String) prop.get("driver");
			*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public static Connection getConnection()
	{	con=tlocal.get();
	if(con==null) {
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost/coda4","root","root");
			con.setAutoCommit(false);
			tlocal.set(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		return con;
	}
	synchronized public static void closeConnection(Exception e,Savepoint s)
	{
		con=tlocal.get();
		if(con!=null) {
			try
			{
				if(e==null) {
					con.commit();
				}
				else {
					if(s==null) {
						con.rollback();
					}
					else {
						con.rollback(s);
						con.commit();
					}
				}
				con.close();
				tlocal.remove();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}
