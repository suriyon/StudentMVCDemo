<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Student</title>
</head>
<body>
	<h2>Edit Student</h2>
	<form action="StudentController?action=updatestudent" method="post">
		<table>
			<tr>
				<td>รหัสนักศึกษา</td>
				<td><input type="text" name="id" value="${student.id }" readonly="readonly"> </td>
			</tr>
			<tr>
				<td>ชื่อ-นามสกุล</td>
				<td><input type="text" name="name" value="${student.name }"> </td>
			</tr>
			<tr>
				<td>อายุ</td>
				<td><input type="number" name="age" value="${student.age }"> </td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"> </td>
			</tr>
		</table>
	</form>
</body>
</html>