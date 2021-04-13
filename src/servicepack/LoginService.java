package servicepack;

import java.sql.SQLException;

public interface LoginService {
	public boolean checkUser(String username,String pass) throws SQLException;
	public boolean checkFlag(String username);
	public int updateFlag(String username,int flag);
	public int registerUser(int userid,String username,String pass,int flag);
}
