<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
<link rel="stylesheet" type="text/css" href="<spring:url value='/css/studentForm_style.css' />">
</head>
<body>

<div class="form-container">
    <h2>
        <c:choose>
            <c:when test="${student.id != null}">
                ✏ Edit Student
            </c:when>
            <c:otherwise>
                ➕ Add Student
            </c:otherwise>
        </c:choose>
    </h2>

    <form action="${pageContext.request.contextPath}/students/save" method="post">
        <!-- Hidden field for ID (needed for update) -->
        <c:if test="${student.id != null}">
            <input type="hidden" name="id" value="${student.id}" />
        </c:if>

        <label>Name:</label>
        <input type="text" name="name" value="${student.name}" required />

        <label>Course:</label>
        <input type="text" name="course" value="${student.course}" required />

        <label>Age:</label>
        <input type="number" name="age" min="0" value="${student.age}" required />

        <label>City:</label>
        <input type="text" name="city" value="${student.city}" required />

        <button type="submit">Save</button>
    </form>

    <a href="${pageContext.request.contextPath}/students" class="btn-back">⬅ Back to Dashboard</a>
</div>

</body>
</html>
