<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Open Electives List</title>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<c:url var="findCategoriesURL" value="/categories" />
<c:url var="findThemeSubCategoriesURL" value="/themesubcategories" />
<c:url var="findSubCategoriesURL" value="/subcategories" />

<script type="text/javascript">
$(document).ready(function() { 
	$('#theme').change(
		function() {
			$.getJSON('${findCategoriesURL}', {
				theme : $(this).val(),
				ajax : 'true'
			}, function(data) {
				var html = '<option value="0">Select from Valid Categories for this Theme</option>';
				var len = data.length;
				for ( var i = 0; i < len; i++) {
					html += '<option value="' + data[i].categoryId + '">'
							+ data[i].name + '</option>';
				}
				html += '</option>';
				$('#category').html(html);
			});
			$.getJSON('${findThemeSubCategoriesURL}', {
					theme : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="0">Select from Valid Sub-Categories for this Theme</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].subCategoryId + '">'
								+ data[i].name + '</option>';
					}
					html += '</option>';
					$('#subcategory').html(html);
				});
		});
	$('#category').change(
			function() {
				$.getJSON('${findSubCategoriesURL}', {
						subtheme : $(this).val(),
						ajax : 'true'
					}, function(data) {
						var html = '<option value="0">Select from Valid Sub-Categories for this Category</option>';
						var len = data.length;
						for ( var i = 0; i < len; i++) {
							html += '<option value="' + data[i].subCategoryId + '">'
									+ data[i].name + '</option>';
						}
						html += '</option>';
						$('#subcategory').html(html);
					});
			});
});
</script>
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

.header {
	font-size: 22px;
	width: 720px;
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
	width: 760px;
	text-align: left;
}

.dropdown {
	float: right;
	width: 580px;
}

.input {
	float: right;
	width: 575px;
	height: 18px;
}

.submit {
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
}

.submit input {
	width: 200px;
	height: 30px;
}
</style>
</head>
<body>
	<center>


		<form:form method="GET" action="/electives/getCourseList">
			<div class="header">Open Elective List</div>
			<div class="filter">
				Semesters: <select name="semester" id="semester" class="dropdown">
					<option value=0>Select a Semester</option>
					<c:forEach var="semester" items="${semesterList}">
						<option value="${semester.semesterId}">${semester.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="filter">
				Themes: <select name="theme" id="theme" class="dropdown">
					<option value=0>Select a Theme</option>
					<c:forEach var="theme" items="${themeList}">
						<option value="${theme.themeId}">${theme.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="filter">
				Categories: <select name="category" id="category" class="dropdown">
					<option value=0>Select a Category</option>
					<c:forEach var="category" items="${categoryList}">
						<option value="${category.categoryId}">${category.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="filter">
				Sub-Categories: <select name="subcategory" id="subcategory" class="dropdown">
					<option value=0>Select a Sub Category</option>
					<c:forEach var="subcategory" items="${subcategoryList}">
						<option value="${subcategory.subCategoryId}">${subCategory.name}</option>
					</c:forEach>
				</select>
			</div>

			<div class="filter">
				Discipline/Subject: <input name="discipline" class="input" />
			</div>
			<div class="filter">
				Pre-requisites: <input name="prereqs" class="input" />
			</div>
			<div class="filter">
				Anti-requisites: <input name="antireqs" class="input" />
			</div>
			<div class="submit">
				<input type="submit" value="Submit" />
			</div>
			<table border="1">
				<tr>
					<td class="heading">Course</td>
					<td class="heading">Name</td>
					<td class="heading">Description</td>
					<td class="heading">Academic Organization</td>
					<td class="heading">Academic Discipline</td>
					<td class="heading">Pre-requisites</td>
					<td class="heading">Anti-requisites</td>
				</tr>
				<c:forEach var="course" items="${courseList}">
					<tr>
						<td>${course.subject} ${course.catalogNbr}</td>
						<td>${course.courseTitle}</td>
						<td class="bigcol">${course.calendarDescription}</td>
						<td>${course.acadGroup}</td>
						<td>${course.acadOrg}</td>
						<td>${course.prerequisites}</td>
						<td>${course.antirequisites}</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</center>

</body>
</html>