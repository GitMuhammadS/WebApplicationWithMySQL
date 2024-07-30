package com.shahbaz.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.shahbaz.entity.Client;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ClientExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.addHeader("Content-Disposition", "attchment;filename=client.xlsx");
		
		@SuppressWarnings("unchecked")
		List<Client> list=(List<Client>) model.get("list");
		Sheet sheet=workbook.createSheet("CLIENT");
		setHeader(sheet);
		setBody(sheet,list);
		
	}

	private void setBody(Sheet sheet, List<Client> list) {
		int rowNum=1;
		for(Client client:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(client.getId());
			row.createCell(1).setCellValue(client.getClientName());
			row.createCell(2).setCellValue(client.getWorkOrderNo());
			row.createCell(3).setCellValue(client.getAddress());
			row.createCell(4).setCellValue(client.getCallReportedBy());
			row.createCell(5).setCellValue(client.getCallAttendedTime().toString());
			row.createCell(6).setCellValue(client.getInvoiceNo());
			row.createCell(7).setCellValue(client.getNatureOfProblem());
			row.createCell(8).setCellValue(client.getPriorityOfWork());
			row.createCell(9).setCellValue(client.getTypeOfWork());
			row.createCell(10).setCellValue(client.getNatureOfProblem());
			row.createCell(11).setCellValue(client.getCallAttendedBy());
			row.createCell(12).setCellValue(client.getCallAttendedTime().toString());
			row.createCell(14).setCellValue(client.getObservation());
			row.createCell(15).setCellValue(client.getWorkDone());
			row.createCell(16).setCellValue(client.getRemarks());
		}
		
	}

	private void setHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("SL NO");
		row.createCell(1).setCellValue("CLIENT NAME");
		row.createCell(2).setCellValue("WORK ORDER NO");
		row.createCell(3).setCellValue("ADDRESS");
		row.createCell(4).setCellValue("CALL REPORTED BY");
		row.createCell(5).setCellValue("DATE TIME");
		row.createCell(6).setCellValue("INVOICE NO");
		row.createCell(7).setCellValue("NATURE OF PROBLEM");
		row.createCell(8).setCellValue("PRIORITY OF WORK");
		row.createCell(9).setCellValue("TYPES OF WORK");
		row.createCell(10).setCellValue("NATURE OF WORK");
		row.createCell(11).setCellValue("CALL ATTENDED BY");
		row.createCell(12).setCellValue("DATE TIME");
		row.createCell(13).setCellValue("ID NO");
		row.createCell(14).setCellValue("OBSERVATION");
		row.createCell(15).setCellValue("WORK DONE");
		row.createCell(16).setCellValue("REMARKS");
	}

}
