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
.bigcol{  
 font-size: 15px;  
 color: black;  
 width: 400px;  
 height: 22px;  
 text-align: center;  
} 
</style>  
</head>  
<body>  
 <center>  
    
   
 <form:form  method="GET" action="/CourseCatMVC/getCourseList">  
 <b>Course List | Ryerson University </b>  
   <p>Themes:
   <select name="theme">
   <option value=0> Select a Theme</option>
   <c:forEach var="theme" items="${themeList}">
   <option value="${theme.themeId}">${theme.name}</option>
   </c:forEach>
   </select>
   <p>
  <p>Categories:
   <select name="category" onchange="this.form.submit()">
   <option value=0> Select a Category</option>
   <c:forEach var="category" items="${categoryList}">
   <option value="${category.categoryId}">${category.name}</option>
   </c:forEach>
   </select>
   <p>
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