package servicepack;

import java.sql.SQLException;

import daopack.UserDAO;
import daopack.UserDTO;

public class LoginServiceImpl implements LoginService,Cloneable{
	private LoginServiceImpl()
	{
	}
	private static LoginServiceImpl loginService;
	private UserDAO userDAO;
	public LoginServiceImpl(UserDAO userdao)
	{
		this.userDAO=userdao;
	}
	public final UserDAO getUserDAO() {
		return userDAO;
	}
	public final void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	synchronized public static LoginServiceImpl getLoginService()
	{
		if(loginService==null)
		{
			loginService=new LoginServiceImpl();
		}
		return loginService.createClone();
	}
	public LoginServiceImpl createClone() 
	{
		try {
			return (LoginServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean checkUser(String username, String pass) throws SQLException {
		
			UserDTO userDTO=userDAO.findByName(username);

			if(userDTO!=null)
			{	
				if(userDTO.getPassword().equals(pass))
				{
					return true;
				}
					
			}
			return false;
	
	}

	@Override
	public boolean checkFlag(String username) {
		UserDTO userdto;
		try {
			userdto = userDAO.findByName(username);
		
		if(userdto!=null)
		{
			if(userdto.getFlag()==0)
			{
				return true;
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int updateFlag(String username, int flag) {
		int n=0;
		UserDTO userdto;
		try {
			userdto = userDAO.findByName(username);
		if(userdto!=null) {
			userdto.setFlag(flag);
			n=userDAO.update(userdto);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int registerUser(int userid, String username, String pass, int flag) {
		UserDTO userdto=new UserDTO();
		userdto.setFlag(flag);
		userdto.setPassword(pass);
		userdto.setUsername(username);
		userdto.setUserid(userid);
		int r;
		try {
			r = userDAO.insert(userdto);
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	

}
