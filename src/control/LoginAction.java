package control;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.UserDAOImpl;
import servicepack.LoginServiceImpl;

public class LoginAction implements Action {
	public LoginAction()
	{
		
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		String username=request.getParameter("username");
		String pass=request.getParameter("pass");
		LoginServiceImpl loginService=LoginServiceImpl.getLoginService();
		loginService.setUserDAO(UserDAOImpl.getUserDAOImpl());
		if(loginService.checkUser(username,pass))
		{
			if(loginService.checkFlag(username))
			{
				HttpSession session=request.getSession();
				long mt=System.currentTimeMillis();
				session.setAttribute("invoiceid",mt );
				session.setAttribute("username", username);
				LocalDateTime l=LocalDateTime.now();
				session.setAttribute("date", Date.valueOf(l.toLocalDate()));
				int n=loginService.updateFlag(username, 1);
				System.out.println("if"+n);
				return "login.success";	
			}
			else
			{HttpSession session=request.getSession();

			long mt=System.currentTimeMillis();
			session.setAttribute("invoiceid",mt );
			session.setAttribute("username", username);
			
				System.out.print("else");
				return "login.already";
			}
		}
		else
		{
			return "login.register";
		}
		
	}

}
