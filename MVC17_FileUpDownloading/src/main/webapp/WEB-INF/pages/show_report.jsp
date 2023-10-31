<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All JS</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty jsinfo}">
			<table border="1px" text-align="center">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
					<th>Qualification</th>
					<th>Resume</th>
					<th>Photo</th>
				</tr>
				<c:forEach var="js" items="${jsinfo}">
					<tr>
						<td>${js.jsId}</td>
						<td>${js.jsName}</td>
						<td>${js.jsAddress}</td>
						<td>${js.qualification}</td>
						<td><a href="download?id=${js.jsId}&type=resume">Resume</a></td>
						<td><a href="download?id=${js.jsId}&type=photo">Photo</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>No Records found</h1>
		</c:otherwise>
	</c:choose>

</body>
</html>