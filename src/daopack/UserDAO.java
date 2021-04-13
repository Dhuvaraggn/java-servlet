package daopack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
	public UserDTO findByName(String username) throws SQLException;
	public void getById(Integer userid) throws SQLException;
	public ResultSet getAll()throws SQLException;
	public int insert(UserDTO userdto)throws SQLException;
	public int update(UserDTO userdto)throws SQLException;
	public int deleteById(Integer userid)throws SQLException;
	public int deleteByUser(UserDTO userdto)throws SQLException;
	public void setflag(int flag,String username) throws SQLException;
}
