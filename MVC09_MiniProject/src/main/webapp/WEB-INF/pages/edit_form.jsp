<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div id="regform">
		<frm:form modelAttribute="memp">
			<table id="customers">
				<tr>
					<th colspan="2"><h2 id="head">Edit Employee Details</h2></th>
				</tr>
				<tr>
					<td>Employee iD:</td>
					<td><frm:input path="empno" readonly="true" /></td>
				</tr>
				<tr>
					<td>Employee Name:</td>
					<td><frm:input path="ename" /></td>
				</tr>
				<tr>
					<td>Job:</td>
					<td><frm:select path="job">
							<option value="Vice_president">President</option>
							<option value="Director">Manager</option>
							<option value="SrManager">SrManager</option>
							<option value="Manager">Manager</option>
							<option value="SrAssociate">SrAssociate</option>
							<option value="Associate">Associate</option>
							<option value="Analyst">Analyst</option>
							<option value="Trainee">Trainee</option>
						</frm:select></td>
				</tr>
				<tr>
					<td>Manager:</td>
					<td><frm:input path="mgr" /></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><frm:input path="sal" /></td>
				</tr>
				<tr>
					<td>Department No:</td>
					<td><frm:input path="deptno" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save"></td>
				</tr>
			</table>
		</frm:form>
	</div>

</body>
</html>