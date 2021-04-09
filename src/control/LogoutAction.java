package control;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.UserDAOImpl;
import servicepack.LoginServiceImpl;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session=request.getSession();
		String s=session.getAttribute("username").toString();
		LoginServiceImpl loginserv=LoginServiceImpl.getLoginService();
		loginserv.setUserDAO(UserDAOImpl.getUserDAOImpl());
		System.out.print("logout");
		int n=loginserv.updateFlag(s, 0);
		System.out.println("logoutif"+n);
		session.setAttribute("username",null);
		return "logout.success";
		
	}

}
