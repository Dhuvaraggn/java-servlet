package servicepack;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import daopack.InvoiceTransDAOImpl;
import daopack.InvoiceTransDTO;
import daopack.ItemDAOImpl;
import daopack.ItemDTO;

public class PDFServiceImpl implements PDFService,Cloneable{
	private PDFServiceImpl()
	{
		
	}
	private static PDFServiceImpl pdfServ;
	synchronized public static PDFServiceImpl getPDFServ()
	{
		if(pdfServ==null)
		{
			pdfServ=new PDFServiceImpl();
		}
		return pdfServ.createClone();
	}
	private PDFServiceImpl createClone()
	{
		try {
			return (PDFServiceImpl) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	public void createPdf(String invoiceid) {
		try {
			LocalDateTime l=LocalDateTime.now();
			PdfWriter pw=new PdfWriter("C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\servletproj\\\\"+invoiceid+".pdf");
			PdfDocument pd=new PdfDocument(pw);
			pd.addNewPage();
			Document d=new Document(pd);
			//AreaBreak a=new AreaBreak();
			Paragraph pe=new Paragraph("Invoice");
			pe.setTextAlignment(TextAlignment.CENTER);
			d.add(pe);
			ImageData data=ImageDataFactory.create("C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\servletproj\\\\WebContent\\\\presidio.jfif");
			Image img=new Image(data);
			img.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			
			d.add(img);
			d.add(new Paragraph(l.format(DateTimeFormatter.ISO_LOCAL_DATE)).setTextAlignment(TextAlignment.RIGHT));
			d.add(new Paragraph(l.getHour()+":"+l.getMinute()+":"+l.getSecond()).setTextAlignment(TextAlignment.RIGHT));
			d.add(new Paragraph(""+l.getDayOfWeek()).setTextAlignment(TextAlignment.RIGHT));
			
			
			float [] widths= {200F,100F,100F,100F};
			Table table=new Table(widths);
			table.setHorizontalAlignment(HorizontalAlignment.RIGHT);
			table.addCell(new Cell().add(new Paragraph("Description")));
			   table.addCell(new Cell().add(new Paragraph("Qty")));       
			      table.addCell(new Cell().add(new Paragraph("Unit Price")));       
			      table.addCell(new Cell().add(new Paragraph("Total")));  
			 ItemDAOImpl itemDAO=ItemDAOImpl.getItemDAOImpl();
			 List<ItemDTO> iteml=itemDAO.getAll();
			 InvoiceTransDAOImpl invoicetDAO=InvoiceTransDAOImpl.getInvoiceTransDAO();
			 List <InvoiceTransDTO> invtransl=invoicetDAO.findAllById(invoiceid);
			for(int i=0;i<iteml.size();i++)
			{
				for(int j=0;j<invtransl.size();j++)
				{
					if(iteml.get(i).getItemname().equals(invtransl.get(j).getItemname()))
					{
						 table.addCell(new Cell().add(new Paragraph(iteml.get(i).getItemname())));
						 table.addCell(new Cell().add(new Paragraph(invtransl.get(j).getQty()+"")));
						 table.addCell(new Cell().add(new Paragraph(iteml.get(i).getPrice()+"")));
						 table.addCell(new Cell().add(new Paragraph(( invtransl.get(j).getQty()*iteml.get(i).getPrice())+"")));
							
					}
				}
			}
			 
		/*	 String[] f= {"Vegfry","Chicken","Mutton","Rice","Daal"};
			 for(int i=0;i<5;i++) {
				 if(m.containsKey(f[i])) {
			 table.addCell(new Cell().add(new Paragraph(f[i])));
			 table.addCell(new Cell().add(new Paragraph(m.get(f[i])+"")));
			 table.addCell(new Cell().add(new Paragraph("10")));
			 table.addCell(new Cell().add(new Paragraph((Integer.parseInt((String) m.get(f[i]))*10)+"")));
				 }
			 }
*/
			 d.add(table);
			 d.add(new Paragraph("sgst\t"+100).setTextAlignment(TextAlignment.RIGHT));
			 d.add(new Paragraph("cgst\t"+100).setTextAlignment(TextAlignment.RIGHT));
			 d.add(new Paragraph("discount\t"+100).setTextAlignment(TextAlignment.RIGHT));
			 d.add(new Paragraph("total\t"+100).setTextAlignment(TextAlignment.RIGHT));
				
			 
			System.out.print("pdf create");
			d.close();
			pd.close();
			pw.close();
			}
	catch(Exception e) {e.printStackTrace();}
	}
}

