<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<title>Open Elective Selection Tool</title>

<script src="https://code.jquery.com/jquery-1.10.1.min.js"></script>
<link href="<c:url value="/resources/css/pif.css" />" rel="stylesheet">
<c:url var="findCategoriesURL" value="/categories" />
<c:url var="findThemeSubCategoriesURL" value="/themesubcategories" />
<c:url var="findSubCategoriesURL" value="/subcategories" />

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//Set the input search values after the page is refreshed
						//Might need an AJAX implementation in future
						$('#semester').val('${selectSemester}');
						$('#theme').val('${selectTheme}');
						$('#category').val('${selectCategory}');
						$('#subcategory').val('${selectSubCategory}');
						$('#discipline').val('${selectDiscipline}');
						$('#prereqs').val('${selectPrerequisites}');
						$('#antireqs').val('${selectAntirequisites}');

						$('#theme')
								.change(
										function() {
											$
													.getJSON(
															'${findCategoriesURL}',
															{
																theme : $(this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="0">Select from Valid Categories for this Theme</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].categoryId + '">'
																			+ data[i].name
																			+ '</option>';
																}
																html += '</option>';
																$('#category')
																		.html(
																				html);
																html2 = '<option value="0">To see a list of SubCategories, please select a Category</option>';
																$(
																		'#subcategory')
																		.html(
																				html2);
															});
											/* $.getJSON('${findThemeSubCategoriesURL}', {
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
												}); */
										});
						$('#category')
								.change(
										function() {
											$
													.getJSON(
															'${findSubCategoriesURL}',
															{
																category : $(
																		this)
																		.val(),
																ajax : 'true'
															},
															function(data) {
																var html = '<option value="0">Select from Valid Sub-Categories for this Category</option>';
																var len = data.length;
																for (var i = 0; i < len; i++) {
																	html += '<option value="' + data[i].subCategoryId + '">'
																			+ data[i].name
																			+ '</option>';
																}
																html += '</option>';
																$(
																		'#subcategory')
																		.html(
																				html);
															});
										});
					});
</script>

</head>
<body>
	<center>


		<form:form method="GET" action="/OpenElectives/getCourseList">
			<body>
				<div class="siteWrapper">
					<div class="pageWrapper">

						<div class="globalNavigation">
							<a href="http://www.ryerson.ca/" class="globalLogo"><img
								src="http://www.ryerson.ca/content/dam/images/ryerson_logo_stacked.jpg"
								alt="Ryerson University" title="Ryerson University"
								style="border: none;"></a>

						</div>
						<div class="header">
							<p>Open Elective Selection Tool</p>
						</div>
						<div class="contentArea">
							<h1>Getting Started</h1>
							<p>
								This pilot project seeks to enhance and facilitate student
								selection of courses from the <strong>Open Electives
									Table</strong>.&nbsp; As Ryerson moves towards a system that increases
								choice in terms of possible electives, students are faced with a
								variety of options and only some will be coherent with their
								core program.&nbsp; As such, the open elective selection tool
								you are now using seeks to facilitate this choice by providing
								you with information about available open electives by
								categorizing them by theme area, described in detail in this
								document.&nbsp; Each one of the theme areas is divided into
								several categories and sub-categories to help you further refine
								your search.&nbsp; It is important to reiterate that the courses
								that appear in this database are not an exhaustive list of all
								available electives across Ryerson but only covers those listed
								on the Open Electives Table.
							</p>
							<p>This method of classifying courses by themes is only meant
								to guide your selection and is not a substitute to academic
								program planning or any advising information you may receive
								from your department or school.&nbsp; Moreover, your selection
								of courses from a specific theme area will not appear anywhere
								on your transcript or any of your student records.&nbsp; Our
								hope is that by classifying a large amount of available open
								electives into manageable theme areas that this will assist you
								in focusing on your areas of interest in terms of elective
								selection.&nbsp;</p>
							<p>Finally, please note that this database is not a
								substitute for using the official SAS system to sign up for
								courses or to check course availability and offerings. While we
								make an effort to maintain this database with up to date
								information, real-time changes and the most complete and
								accurate information regarding course availability and offerings
								is available through SAS. &nbsp;&nbsp;&nbsp;</p>


							<h2>Choose Elective Options</h2>
							<p>
								For more information please read <a
									href="/OpenElectives/descriptions">themes and descriptions
									&gt;&gt;</a>
							</p>
							<div class="filter">
								<strong>Semesters: <select name="semester"
									id="semester" class="dropdown">
										<option value=0>Select a Semester</option>
										<c:forEach var="semester" items="${semesterList}">
											<option value="${semester.semesterId}">${semester.name}</option>
										</c:forEach>
								</select>
								</strong>
							</div>
							<br />
							<div class="filter">
								<strong>Themes: <select name="theme" id="theme"
									class="dropdown">
										<option value=0>Select a Theme</option>
										<c:forEach var="theme" items="${themeList}">
											<option value="${theme.themeId}">${theme.name}</option>
										</c:forEach>
								</select>
								</strong>
							</div>
							<br />
							<div class="filter">
								<strong>Categories: <select name="category"
									id="category" class="dropdown">
										<option value=0>Select a Category</option>
										<c:forEach var="category" items="${categoryList}">
											<option value="${category.categoryId}">${category.name}</option>
										</c:forEach>
								</select></strong>
							</div>
							<br />
							<div class="filter">
								<strong>SubCategories: <select name="subcategory"
									id="subcategory" class="dropdown">
										<c:if test="${empty subcategoryList}">
											<option value=0>To see a list of SubCategories,
												please select a Category</option>
										</c:if>
										<c:forEach var="subcategory" items="${subcategoryList}">
											<option value="${subcategory.subCategoryId}">${subcategory.name}</option>
										</c:forEach>
								</select></strong>
							</div>
							<br />

							<div class="filter">
								<strong>Subject: <input name="discipline"
									id="discipline" type="text" class="input" /></strong>
							</div>
							<br />
							<div class="filter">
								<strong>Pre-requisites: <input name="prereqs"
									id="prereqs" type="text" class="input" /></strong>
							</div>
							<br />
							<div class="filter">
								<strong>Anti-requisites: <input name="antireqs"
									id="antireqs" type="text" class="input" /></strong>
							</div>
							<br />
							<div class="submit">
								<input type="submit" value="Submit" />
							</div>


							<c:if test="${empty courseList}">
								<h3>The search yielded no results. Please refine your
									criteria and try again</h3>
							</c:if>

							<c:if test="${not empty courseList}">
								<br />
								<table class="electives" cellpadding="10" cellspacing="0">
									<tbody>
										<tr valign="top" class="subhead">
											<td>COURSE</td>
											<td>NAME</td>
											<td>DESCRIPTION</td>
											<td>ACADEMIC <br> ORGANIZATION
											</td>
											<td>ACADEMIC<br> DISCIPLINE
											</td>
											<td>PRE-REQUISITES</td>
											<td>ANTI-REQUISITES</td>
										</tr>
										<c:forEach var="course" items="${courseList}"
											varStatus="status">
											<c:choose>
												<c:when test="${status.index % 2 == 1}">
													<tr class="grey">
												</c:when>
												<c:otherwise>
													<tr>
												</c:otherwise>
											</c:choose>
											<td align="left" valign="top">${course.subject}${course.catalogNbr}</td>
											<td align="left" valign="top">${course.courseTitle}</td>
											<td align="left" valign="top">${course.calendarDescription}</td>
											<td align="left" valign="top">${course.acadGroup}</td>
											<td align="left" valign="top">${course.acadOrg}</td>
											<td align="left" valign="top">${course.prerequisites}</td>
											<td align="left" valign="top">${course.antirequisites}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</c:if>


							<!-- footer -->

							<div id="footer_blurb">

								<span id="footer_copyright"> <script
										language="JavaScript">
								<!--
									var today = new Date();
									var year = today.getFullYear();
									document.write("&copy; " + year
											+ " Ryerson University");
								//-->
								</script>
								</span> &nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp; <span id="footer_address">
									350 Victoria Street, Toronto, Ontario, Canada M5B 2K3 </span> <br />
								<a href="http://www.ryerson.ca/privacy/">Privacy Policy</a>
								&nbsp;&nbsp;&nbsp; <a
									href="http://www.ryerson.ca/accessibility/">Accessibility</a>
								&nbsp;&nbsp;&nbsp; <a
									href="http://www.ryerson.ca/ryerson.ca/terms.html">Terms
									&amp; Conditions</a>

							</div>
							<!-- end footer -->
						</div>
					</div>
				</div>
		</form:form>
	</center>
</body>
</html>