package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    RequestProcessor rp;
    public void init(ServletConfig config) throws ServletException {
		try {
		rp=new RequestProcessor();
		ServletContext application=config.getServletContext();
		String configfile=config.getInitParameter("config");
		String dbconfigfile=config.getInitParameter("dbconfig");
		String configpath=application.getRealPath(configfile);
		String dbconfigpath=application.getRealPath(dbconfigfile);
		
		Properties configProp=new Properties();
		configProp.load(new FileInputStream(configpath));
		
		Properties dbConfigProp=new Properties();
		dbConfigProp.load(new FileInputStream(dbconfigpath));
		
		application.setAttribute("configProp", configProp);
		application.setAttribute("dbConfigProp", dbConfigProp);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp.process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
