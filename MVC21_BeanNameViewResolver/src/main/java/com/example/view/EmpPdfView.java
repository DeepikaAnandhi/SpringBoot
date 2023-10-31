package com.example.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.example.entity.Employee;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component("pdfreport")
public  class EmpPdfView extends AbstractPdfView {

	


	@Override
	public void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Employee> list = (List<Employee>) map.get("empList");
		
		Paragraph para = new Paragraph("Employees Report", new Font(Font.COURIER,20,Font.BOLD,Color.BLUE));
		
		document.add(para);
	
		
		Table table = new Table(5,list.size());
		for(Employee emp:list) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(String.valueOf(emp.getDeptno()));
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSal()));
		}
		document.add(table);
	
	}

}
