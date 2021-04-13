package services;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.layout.element.Paragraph;

import daopack.InvoiceTransDAOImpl;
import daopack.InvoiceTransDTO;
import daopack.ItemDAOImpl;
import daopack.ItemDTO;

public class ExcelServiceImpl implements ExcelService,Cloneable{
	
	private static ExcelServiceImpl excelServ;
	
	public static  ExcelServiceImpl getExcelServ()
	{
		if(excelServ==null)
		{
			excelServ=new ExcelServiceImpl();
		}
		return excelServ.createClone();
	}
	private  ExcelServiceImpl createClone()
	{
		try {
			return (ExcelServiceImpl)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	


	public ExcelServiceImpl(){
	//writeExcel(wb,sheet);
	//readExcel(wb,sheet);	
		String filename="C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\servletproj\\\\InvoiceExcel.xlsx";  

		try {
			System.out.print(getrowExcel(filename));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

	public static int getrowExcel(String s) throws Exception {
		FileInputStream fis=new FileInputStream(s);
		XSSFWorkbook wb=new XSSFWorkbook(fis); 
		XSSFSheet sheet=wb.getSheetAt(0); 
		int rcount=0;
		for(Row r:sheet) {
			rcount++;
		}
		fis.close();
		wb.close();
		return rcount;

	}

	@Override
	public void excelWrite(String invoiceid) {

		try {
			String filename="C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\project\\\\InvoiceExcel.xlsx";  

		int rcount=getrowExcel(filename);
		//	int rcount=1;
		FileInputStream fis=new FileInputStream(filename);
		System.out.print(fis);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		System.out.print(sheet);
		Row row1=sheet.createRow(rcount+1);
		
		ItemDAOImpl itemDAO=ItemDAOImpl.getItemDAOImpl();
		 List<ItemDTO> iteml=itemDAO.getAll();
		
		InvoiceTransDAOImpl invoicetDAO=InvoiceTransDAOImpl.getInvoiceTransDAO();
		List <InvoiceTransDTO> invtransl=invoicetDAO.findAllById(invoiceid);
		Cell c1=row1.createCell(0);
		c1.setCellValue(invoiceid+"");
		float total=0;
		for(int i=0;i<iteml.size();i++)
		{
			for(int j=0;j<invtransl.size();j++)
			{
				if(iteml.get(i).getItemname().equals(invtransl.get(j).getItemname()))
				{
						c1=row1.createCell(i+1);
						c1.setCellValue(iteml.get(i).getPrice()*invtransl.get(j).getQty()+"");
						total+=iteml.get(i).getPrice()*invtransl.get(j).getQty();
				}
			}
		}
		float sgst=(float) (total*0.1);
		float cgst=(float) ((float) total*0.1);
		float discount=(float) (total*0.05);
		float tot=total+sgst+cgst-discount;
		int l=iteml.size();
		c1=row1.createCell(l+1);
		c1.setCellValue(sgst+"");
		c1=row1.createCell(l+2);
		c1.setCellValue(cgst+"");
		c1=row1.createCell(l+3);
		c1.setCellValue(discount+"");
		c1=row1.createCell(l+4);
		c1.setCellValue(tot+"");

		
		FileOutputStream fo=new FileOutputStream(filename);  		
		wb.write(fo);
		fo.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//	intoExcel(filename,m,row,mt);
	//	System.out.print(getrowExcel(filename));
	}
	/*public static void readExcel(XSSFWorkbook wb,XSSFSheet sheet) {
	FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
	  
	for(Row row: sheet)    
	{  
	for(Cell cell: row)      
	{ 
	switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
	{  
	case NUMERIC:   
	System.out.print(cell.getNumericCellValue()+ "\t\t");   
	break;  
	case STRING:   
	System.out.print(cell.getStringCellValue()+ "\t\t");  
	break;  
	} 
	}  
	System.out.println();  
	}	public static  void intoExcel(String filename,Map m,int rcount,long mt) throws Exception {
		FileInputStream fis=new FileInputStream(filename);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		System.out.print(sheet);
		Row row1=sheet.createRow(rcount+1);
		Cell c1=row1.createCell(0);
		LocalDateTime l=LocalDateTime.now();
		c1.setCellValue(mt+"");
		c1=row1.createCell(1);
		c1.setCellValue(m.get("Mutton")+"");
		c1=row1.createCell(2);
		c1.setCellValue(m.get("Chicken")+"");
		c1=row1.createCell(3);
		c1.setCellValue(m.get("Vegfry")+"");
		c1=row1.createCell(4);
		c1.setCellValue(m.get("Daal")+"");
		c1=row1.createCell(5);
		c1.setCellValue(m.get("Rice")+"");
		c1=row1.createCell(6);
		c1.setCellValue(m.get("sgst")+"");
		c1=row1.createCell(7);
		c1.setCellValue(m.get("cgst")+"");
		c1=row1.createCell(8);
		c1.setCellValue(m.get("discount")+"");
		c1=row1.createCell(9);
		c1.setCellValue(m.get("total")+"");
		
		FileOutputStream fo=new FileOutputStream(filename);  		
		wb.write(fo);
		fo.close();
	}*/
	
	


