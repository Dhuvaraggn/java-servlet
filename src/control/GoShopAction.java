package control;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoShopAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
			return "goshop.success";
	}

}
