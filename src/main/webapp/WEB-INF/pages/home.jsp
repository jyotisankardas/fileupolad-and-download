<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body bgcolor="black" style="color: white">
	<h1 style="color: red; text-align: center;">File Uploading And
		Downloading</h1>
	<form:form enctype="multipart/form-data" modelAttribute="uplCmd"
		action="register.htm">
		<table border="09"
			style="border-color: lime; align-content: center; width: 40%; border-style: inset; background-color:purple;"
			align="center">
			<tr height="50">
				<td align="center">Select Your Photo :::</td>
				<td align="center"><form:input type="file" path="file1"/></td>
			</tr>
			<tr height="50">
				<td align="center">Select Your Resume</td>
				<td align="center"><form:input type="file" path="file2"/>
			</tr>
			<tr height="50">
				<td align="center"><input type="submit" value="UPLOAD"></td>
				<td align="center"><a href="getAllFilesList.htm" style="color:red;">Download Files</a></td>
			</tr >
		</table>
	</form:form>

</body>
</html>