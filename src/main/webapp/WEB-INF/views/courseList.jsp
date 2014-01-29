<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Open Electives List</title>
<style>
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}

.bigcol {
	font-size: 15px;
	color: black;
	width: 500px;
	height: 22px;
	text-align: center;
}

.filter {
	width: 700px;
	text-align: left;
}

.dropdown {
	float: right;
	width: 580px;
}

.input {
	float: right;
	width: 575px;
}

.submit {
	width: 200px;
	text-align: center;
	margin-top: 10px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<center>


		<form:form method="GET" action="/electives/getCourseList">
			<b>Course List | Ryerson University </b>
			<div class="filter">
				Themes: <select name="theme" class="dropdown">
					<option value=0>Select a Theme</option>
					<c:forEach var="theme" items="${themeList}">
						<option value="${theme.themeId}">${theme.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="filter">
				Subthemes: <select name="subtheme" class="dropdown">
					<option value=0>Select a Subtheme</option>
					<c:forEach var="subtheme" items="${subthemeList}">
						<option value="${subtheme.subthemeId}">${subtheme.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="filter">
				Categories: <select name="category" class="dropdown">
					<option value=0>Select a Category</option>
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.categoryId}">${category.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="filter">
				Discipline: <input name="discipline" class="input" />
			</div>
			<div class="submit">
				<input type="submit" value="Submit" />
			</div>
			<table border="1">
				<tr>
					<td class="heading">Course Id</td>
					<td class="heading">Name</td>
					<td class="heading">Description</td>
				</tr>
				<c:forEach var="course" items="${courseList}">
					<tr>
						<td>${course.courseId}</td>
						<td>${course.courseTitle}</td>
						<td class="bigcol">${course.calendarDescription}</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</center>

</body>
</html>