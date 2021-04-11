package Asssignment1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

public class PDFCreation {
	public static void main(Map m,long mt) throws Exception {
		try {
			LocalDateTime l=LocalDateTime.now();
		PdfWriter pw=new PdfWriter("C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\basicproject\\\\"+mt+".pdf");
		PdfDocument pd=new PdfDocument(pw);
		pd.addNewPage();
		Document d=new Document(pd);
		//AreaBreak a=new AreaBreak();
		Paragraph pe=new Paragraph("Invoice");
		pe.setTextAlignment(TextAlignment.CENTER);
		d.add(pe);
		ImageData data=ImageDataFactory.create("C:\\\\Users\\\\VC\\\\eclipse-workspace\\\\basicproject\\\\presidio.jfif");
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
		 String[] f= {"Vegfry","Chicken","Mutton","Rice","Daal"};
		 for(int i=0;i<5;i++) {
			 if(m.containsKey(f[i])) {
		 table.addCell(new Cell().add(new Paragraph(f[i])));
		 table.addCell(new Cell().add(new Paragraph(m.get(f[i])+"")));
		 table.addCell(new Cell().add(new Paragraph("10")));
		 table.addCell(new Cell().add(new Paragraph((Integer.parseInt((String) m.get(f[i]))*10)+"")));
			 }
		 }

		 d.add(table);
		 d.add(new Paragraph("sgst\t"+m.get("sgst")).setTextAlignment(TextAlignment.RIGHT));
		 d.add(new Paragraph("cgst\t"+m.get("cgst")).setTextAlignment(TextAlignment.RIGHT));
		 d.add(new Paragraph("discount\t"+m.get("discount")).setTextAlignment(TextAlignment.RIGHT));
		 d.add(new Paragraph("total\t"+m.get("total")).setTextAlignment(TextAlignment.RIGHT));
			

		System.out.print("pdf create");
		d.close();
		}catch(Exception e) {System.out.print(e);}
	}
}
