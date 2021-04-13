package control;

import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LangAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			String languague=request.getParameter("languague");
			System.out.print(languague);
			ResourceBundle rb=ResourceBundle.getBundle("control.Dictionary",new Locale(languague));
			HttpSession session=request.getSession();
			session.setAttribute("rb", rb);
			return "lang.success";
	}

}
