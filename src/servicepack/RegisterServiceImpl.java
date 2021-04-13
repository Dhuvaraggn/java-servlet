package servicepack;

import java.sql.SQLException;

import daopack.UserDAO;
import daopack.UserDTO;

public class RegisterServiceImpl  implements RegisterService,Cloneable{
	private RegisterServiceImpl()
	{
		
	}
	private UserDAO userDAO;
	private RegisterServiceImpl(UserDAO userdao)
	{
		this.userDAO=userdao;
	}
	
	public final UserDAO getUserDAO() {
		return userDAO;
	}
	public final void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	private static RegisterServiceImpl registerServ;
	synchronized public static RegisterServiceImpl getRegisterServ()
	{
		if(registerServ==null)
		{
			registerServ=new RegisterServiceImpl();
		}
		return registerServ.createClone();
	}
	private RegisterServiceImpl createClone()
	{
		try {
			return (RegisterServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public int insertuser(int userid, String username, String pass, int flag) {
		UserDTO userdto=new UserDTO();
		userdto.setFlag(flag);
		userdto.setPassword(pass);
		userdto.setUsername(username);
		userdto.setUserid(userid);
		int r;
		try {
			 r=userDAO.insert(userdto);
				return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
	}

}
