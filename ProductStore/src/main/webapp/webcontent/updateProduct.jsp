<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
<link rel="stylesheet" type="text/css" href="<spring:url value='/css/addProduct-style.css' />">
</head>
<body>
    <div class="form-container">
        <h2 class="form-title">Update Product</h2>

       <form:form action="add-product" modelAttribute="product"> 
     
			<form:hidden path="productId" />
            <label for="pName">Product Name:</label>
            <form:input type="text" id="pName" path="productName"  required="true" />

			<label for="cLName">Brand:</label>
            <form:input type="text" id="cLName" path="brand"/>
			
            <label for="cCity">Category:</label>
            <form:input type="text" id="cCity" path="brandCategory" required="true"/>
            
            <label for="cCity">Price:</label>
            <form:input type="text" id="cCity" path="price" required="true"/>
            
            <label for="cCity">Stock:</label>
            <form:input type="text" id="cCity" path="stock" required="true"/>

            <button type="submit" class="btn-submit" value="Update">Update</button>
        </form:form>
    </div>
</body>
</html>