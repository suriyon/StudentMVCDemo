<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert Student</title>
</head>
<body>
	<h2>Insert Student</h2>
	<form action="StudentController?action=addstudent" method="post">
		<table>
			<tr>
				<td>รหัสนักศึกษา</td>
				<td><input type="text" name="id" placeholder="enter id"> </td>
			</tr>
			<tr>
				<td>ชื่อ-นามสกุล</td>
				<td><input type="text" name="name" placeholder="enter name"> </td>
			</tr>
			<tr>
				<td>อายุ</td>
				<td><input type="number" name="age" placeholder="enter age"> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add"> </td>
			</tr>
		</table>
	</form>
</body>
</html>