package com.example.view;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.example.entity.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("excelreport")
public class EmpXlView extends AbstractXlsView {
	
	private int i=0;

	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<Employee> list = (List<Employee>) map.get("empList");
		
		Sheet sheet1 = workbook.createSheet("sheet1");
		
		list.forEach(emp->{
			Row row = sheet1.createRow(i);
			row.createCell(0).setCellValue(emp.getEmpno());
			row.createCell(1).setCellValue(emp.getEname());
			row.createCell(2).setCellValue(emp.getDeptno());
			row.createCell(3).setCellValue(emp.getJob());
			row.createCell(4).setCellValue(emp.getSal());
			i++;
		});
		
		
	}

}
