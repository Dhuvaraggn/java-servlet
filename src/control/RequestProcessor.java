package control;

import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestProcessor {
	public void process(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{Properties configProp=(Properties)request.getServletContext().getAttribute("configProp");
		
		String formid=request.getParameter("formid");
		String actionClass=configProp.getProperty(formid);
		System.out.print(formid);
		Action action=(Action)Class.forName(actionClass).getConstructor().newInstance();
		String res=action.execute(request, response);
		String nextpage=configProp.getProperty(res);
		RequestDispatcher rd=request.getRequestDispatcher(nextpage);
		rd.forward(request, response);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
