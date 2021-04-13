package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintAction implements Action {
	public PrintAction() {}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String invoiceid=request.getParameter("invoiceid");
		//String contextPath = request.getServletContext().getRealPath(File.separator);
		String contextPath="C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\project\\\\";
		System.out.print(contextPath);
		File pdfFile = new File(contextPath + invoiceid+".pdf");

		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + invoiceid+".pdf");
		response.setContentLength((int) pdfFile.length());

		try {
			FileInputStream fileInputStream = new FileInputStream(pdfFile);
			OutputStream responseOutputStream;
			try {
				responseOutputStream = response.getOutputStream();
				int bytes;
				while ((bytes = fileInputStream.read()) != -1) {
					responseOutputStream.write(bytes);
					System.out.print(bytes);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				return "pdf printed";
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
				
	}

}
