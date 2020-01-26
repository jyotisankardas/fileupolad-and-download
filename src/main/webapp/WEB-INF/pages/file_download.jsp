<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Download Page</title>
</head>
<body bgcolor="black" style="color:white;">
	<h1 style="color: red; text-align: center">Select Files to
		Download</h1>
	<c:choose>
		<c:when test="${!empty FileLocation}">
			<table border="09"
				style="border-color: lime; align-content: center; width: 40%; border-style: inset; background-color: purple;"
				align="center">
				<tr height="50">
				<th style="color: red">All Files List</th>
				<th style="color: red">Action ::</th>
				</tr>
				<c:forEach var="f" items="${FileLocation}">
					<tr height="50">
						<td align="center">${f}</td>
						<td align="center"><a href="download.htm?fname=${f}" style="color:orange;">DOWNLOAD</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No Files found</h1>
		</c:otherwise>
	</c:choose>
	<h3 style="text-align: center;">
		<a href="home.htm">HOME</a>
	</h3>
</body>
</html>