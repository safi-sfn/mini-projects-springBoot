<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<spring:url value='/css/studentDashboard-style.css' />">
</head>
<body>

<div class="container">
    <h2>🎓 Student Dashboard</h2>

    <!-- Action Bar -->
    <div class="action-bar">
    	 <!-- Show All Student Button -->
        <a href="${pageContext.request.contextPath}/students" class="btn btn-show">Show Students</a>
       
        <!-- Search Form -->
        <form action="${pageContext.request.contextPath}/students/search" method="get">
            <input type="text" name="course" placeholder="Search by Course" required>
            <button type="submit" class="btn btn-search">🔍 Search</button>
        </form>
        
         <!-- Add Student Button -->
        <a href="${pageContext.request.contextPath}/students/new" class="btn btn-add">➕ Add Student</a>
        
        
    </div>
	<!-- Message for Student not Found by Course -->
	<c:if test="${not empty message}">
	    <div style="color: red; font-weight: bold; margin: 10px 0;">
	        ${message}
	    </div>
	</c:if>
    <!-- Student Table -->
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Course</th>
                <th>Age</th>
                <th>City</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="s" items="${allStudent}">
            	    	<c:url var="UpdateLink" value="/students/edit">
                        	<c:param name="id" value="${s.id}"></c:param>
                        </c:url>
                     
                     	<c:url var="DeleteLink" value="/students/delete/${s.id}">
                        	<c:param name="id" value="${s.id}"></c:param>
                        </c:url>
                        
                <tr>
                    <td>${s.name}</td>
                    <td>${s.course}</td>
                    <td>${s.age}</td>
                    <td>${s.city}</td>
                    <td>
                        <a href="${UpdateLink}" class="btn btn-edit">✏ Edit</a>
                        <a href="${DeleteLink}" 
                           class="btn btn-delete" 
                           onclick="return confirm('Are you sure to delete this student?')">🗑 Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>