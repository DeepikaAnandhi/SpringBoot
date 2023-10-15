<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<frm:form modelAttribute="js">

		<table style="text-align:center; border=10px">
			<tr>
				<td>Name: </td>
				<td><frm:input path="jsName"/></td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><frm:input path="jsAddress"/></td>
			</tr>
			<tr>
				<td>Qualification: </td>
				<td><frm:input path="qualification"/></td>
			</tr>
			<tr>
				<td>Resume: </td>
				<td><frm:input type="file" path="resume"/></td>
			</tr>
			<tr>
				<td>Photo: </td>
				<td><frm:input type="file"  path="photo"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="register"/></td>
			</tr>

		</table>


	</frm:form>

</body>
</html>