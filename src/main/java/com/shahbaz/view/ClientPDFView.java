package com.shahbaz.view;

import java.awt.Color;
import java.io.FileOutputStream;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.shahbaz.entity.Client;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ClientPDFView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attachment;filename=Client.pdf");
		
		/*Font font=new Font(Font.BOLD,30,Font.BOLD,Color.BLUE);
		Paragraph p=new Paragraph("ELITE SERVICES",font);
		p.setAlignment(Element.ALIGN_CENTER);
		document.setPageSize(PageSize.A4);
		document.add(p);
		
		Font font1=new Font(Font.BOLD,10,Font.BOLD,Color.BLACK);
		Paragraph p1=new Paragraph("33/1D,Hare Krishna Konar Road, Near White House",font1);
		p1.setAlignment(Element.ALIGN_CENTER);
		document.add(p1);
		
		Font font2=new Font(Font.BOLD,10,Font.BOLD,Color.BLACK);
		Paragraph p2=new Paragraph("Kolkata-700014 ,West Bengal",font2);
		p2.setAlignment(Element.ALIGN_CENTER);
		document.add(p2);
		
		Font font3=new Font(Font.BOLD,10,Font.BOLD,Color.BLACK);
		Paragraph p3=new Paragraph("eliteservices549@gmail.com (+91 8902338075)",font3);
		p3.setAlignment(Element.ALIGN_CENTER);
		document.setPageSize(PageSize.A4);
		document.add(p3);
		
		Font font4=new Font(Font.BOLD,13,Font.BOLD,Color.BLACK);
		Paragraph p4=new Paragraph("GSTIN No: 19AAIFE8456G1Z1",font4);
		p4.setAlignment(Element.ALIGN_CENTER);
		document.setPageSize(PageSize.A4);
		document.add(p4); */
		
		
		Client client=(Client) model.get("client");
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("shahbaz.pdf"));
			document.open(); 
			
			Font font=new Font(Font.BOLD,30,Font.BOLD,Color.BLUE);
			Paragraph p=new Paragraph("ELITE SERVICES",font);
			p.setAlignment(Element.ALIGN_CENTER);
			document.setPageSize(PageSize.A4);
			document.add(p);
			
			Font font1=new Font(Font.BOLD,10,Font.BOLD,Color.BLACK);
			Paragraph p1=new Paragraph("33/1D,Hare Krishna Konar Road, Near White House",font1);
			p1.setAlignment(Element.ALIGN_CENTER);
			document.add(p1);
			
			Font font2=new Font(Font.BOLD,10,Font.BOLD,Color.BLACK);
			Paragraph p2=new Paragraph("Kolkata-700014 ,West Bengal",font2);
			p2.setAlignment(Element.ALIGN_CENTER);
			document.add(p2);
			
			Font font3=new Font(Font.BOLD,10,Font.BOLD,Color.BLACK);
			Paragraph p3=new Paragraph("eliteservices549@gmail.com (+91 8902338075)",font3);
			p3.setAlignment(Element.ALIGN_CENTER);
			document.setPageSize(PageSize.A4);
			document.add(p3);
			
			Font font4=new Font(Font.BOLD,13,Font.BOLD,Color.BLACK);
			Paragraph p4=new Paragraph("GSTIN No: 19AAIFE8456G1Z1",font4);
			p4.setAlignment(Element.ALIGN_CENTER);
			document.setPageSize(PageSize.A4);
			document.add(p4);
			
			Chunk linebreak = new Chunk(new LineSeparator());
			document.add(linebreak); 
			
			Font font5=new Font(Font.BOLD,22,Font.BOLD,Color.BLACK);
			Paragraph p5=new Paragraph("Customer Service Report",font5);
			p5.setAlignment(Element.ALIGN_CENTER);
			document.setPageSize(PageSize.A4);
			document.add(p5);
			
 
			
			//Document iText_Create_Table = new Document();
			 //PdfWriter.getInstance(document, new FileOutputStream("shahbaz.pdf"));
			 //document.open(); 
			 PdfPTable my_first_table = new PdfPTable(2);
			 PdfPCell table_cell;
			 float widthval=10;
			 my_first_table.setSpacingBefore(15f);
			 
			 table_cell=new PdfPCell(new Phrase("CLIENT NAME"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getClientName()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("WORK ORDER NO"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getWorkOrderNo()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("ADDRESS"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getAddress()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("CALL REPORTED BY"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getCallReportedBy()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("CALL REPORTED TIME"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getCallReportedTime().toString()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("INVOICE NO"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getInvoiceNo()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("NATURE OF PROBLEM"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getNatureOfProblem()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("PRIORITY OF WORK"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getPriorityOfWork()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("TYPE OF WORK"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getTypeOfWork()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("NATURE OF WORK"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getNatureOfWork()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("CALL ATTENDED BY"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getCallAttendedBy()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("CALL ATTENDED TIME"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getCallAttendedTime().toString()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("OBSERVATION"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getObservation()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("WORK DONE"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getWorkDone()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("REMARKS"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(client.getRemarks()));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("CUSTOMER'S SIGNATURE"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(""));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         table_cell=new PdfPCell(new Phrase("FEED BACK"));
			 table_cell.setPadding(widthval);/* Padding Set in All Sides */
			 my_first_table.addCell(table_cell); 
			 
			 table_cell=new PdfPCell(new Phrase(""));
	         table_cell.setPadding(widthval); /* Padding Set in All Sides */
	         my_first_table.addCell(table_cell);
	         
	         document.add(my_first_table);
	         document.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}

}
