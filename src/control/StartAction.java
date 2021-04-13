package control;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		return "start.get";
	}

}
