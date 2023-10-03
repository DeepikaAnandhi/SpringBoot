<%@page import="org.hibernate.internal.log.UrlMessageBundle_$logger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Employees Report</title>
</head>
<body>
<%@ include file="welcome.jsp"%>
					<h2 style="text-align:center; color:green">${resultmsg}</h2>
	
			
	<c:choose>
		<c:when test="${!empty empInfo}">
			<table id="customers">
				<tr>
					<th>EmpNo</th>
					<th>EmpName</th>
					<th>Job</th>
					<th>Manager</th>
					<th>Salary</th>
					<th>Department no</th>
					<th>Edit</th>
					<th>Delete</th>
					
				</tr>
				<c:forEach var="emp" items="${empInfo}">
					<tr>
						<td>${emp.empno}</td>
						<td>${emp.ename}</td>
						<td>${emp.job}</td>
						<td>${emp.mgr}</td>
						<td>${emp.sal}</td>
						<td>${emp.deptno}</td>
						<td><a href="edit?no=${emp.empno}"><img src="images/editIcon.jpeg" height="30" width="30" /></a></td>
						<td><a href="delete?no=${emp.empno}" ><img src="images/deleteIcon.png" height="30" width="30" /></a></td>
						
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
		
		<h2 style="text-align:center">Sorry!!! No Records Found</h2>
		
		</c:otherwise>
	</c:choose>


</body>
</html>