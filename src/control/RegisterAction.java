package control;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daopack.UserDAOImpl;
import servicepack.RegisterServiceImpl;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		RegisterServiceImpl registerServ=RegisterServiceImpl.getRegisterServ();
		registerServ.setUserDAO(UserDAOImpl.getUserDAOImpl());
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		int userid=Integer.parseInt(request.getParameter("userid"));
		int flag=0;
		if(registerServ.insertuser(userid, username,pass, flag)>0)
		{
			return "register.success";
		}
		return "register";
	}

}
