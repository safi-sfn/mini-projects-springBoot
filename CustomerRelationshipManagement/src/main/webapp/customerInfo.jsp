<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Information</title>
<link rel="stylesheet" type="text/css" href="./style.css">
</head>
<body>
    <div class="table-container">
        <h2>📋 Customer Information</h2>

		<div class="btn-container">
			<a href="${pageContext.request.contextPath}/show-form"
				class="add-btn">➕ Add New Customer</a>
		</div>

		<c:choose>
            <c:when test="${not empty customer}">
                <table>
                    <thead>
                        <tr>
              
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>City</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cxtmer" items="${customer}">
                        
                        <c:url var="UpdateLink" value="/update-data">
                        	<c:param name="cxid" value="${cxtmer.id}"></c:param>
                        </c:url>
                        
                        <c:url var="DeleteLink" value="/delete-data">
                        	<c:param name="cxid" value="${cxtmer.id}"></c:param>
                        </c:url>
                        
                            <tr>
                               
                                <td>${cxtmer.firstName}</td>
                                <td>${cxtmer.lastName}</td>
                                <td>${cxtmer.city}</td>
                                <td>
                                    <a href="${UpdateLink}" class="action-btn update-btn">Update</a>
                                    <a href="${DeleteLink}" class="action-btn delete-btn">Delete</a>
                                    
                               
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p class="no-data">No customer data available.</p>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html> 