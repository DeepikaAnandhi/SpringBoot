<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div id="regform">
		<frm:form modelAttribute="emp">
		<p style="color:red">
			<frm:errors path="*"/>
		</p>
			<table id="customers">
				<tr>
					<th colspan="2">Add Employee Details</th>
				</tr>

				<tr>
					<td>Employee Name:</td>
					<td><frm:input path="ename" /> <span id="ename"></span></td>
				</tr>
				<tr>
					<td>Job:</td>
					<td><frm:select path="job">
							<option value="president">President</option>
							<option value="vp">Vp</option>
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
					<td><frm:select path="deptno">
							<frm:options items="${dNoList}"/>

						</frm:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</frm:form>
	</div>

</body>
</html>