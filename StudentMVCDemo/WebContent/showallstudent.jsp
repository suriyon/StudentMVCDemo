<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Students</title>
</head>
<body>
	<h2>Show All Students</h2>
	<form action="StudentController?action=search" method="post">
		<label>กรอกชื่อนักศึกษา</label>
		<input type="text" name="name" placeholder="enter name">
		<input type="submit" value="ค้นหา">
	</form>
	<table>
		<thead>
			<tr>
				<th>รหัสนักศึกษา</th>
				<th>ชื่อ-นามสกุล</th>
				<th>อายุ</th>
				<th>แก้ไข</th>
				<th>ลบ</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students }" var="student">
				<tr>
					<td>${student.id }</td>
					<td>${student.name }</td>
					<td>${student.age }</td>
					<td>
						<a href="StudentController?action=edit&id=${student.id }">
							<img src="images/edit.png">
						</a>
					</td>
					<td>
						<a href="StudentController?action=delete&id=${student.id }">
							<img src="images/edittrash.png">
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>