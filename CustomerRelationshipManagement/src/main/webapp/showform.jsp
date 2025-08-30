<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
<link rel="stylesheet" type="text/css" href="./style.css">
<link rel="stylesheet" type="text/css" href="./form-style.css">
</head>
<body>
    <div class="form-container">
        <h2>CRM APP Registration Form</h2>

       <form:form action="cx-registration" modelAttribute="customer"> 
     

            <label for="cFName">Customer First Name</label>
            <form:input type="text" id="cFName" path="firstName"  required="true" />

			<label for="cLName">Customer Last Name</label>
            <form:input type="text" id="cLName" path="lastName"/>
			
            <label for="cCity">City</label>
            <form:input type="text" id="cCity" path="city" required="true"/>

            <button type="submit">Register</button>
        </form:form>
    </div>
</body>
</html>