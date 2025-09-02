<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<spring:url value='/css/addProduct-style.css' />">
</head>
<body>
    <!-- Add Product Form -->
    <div class="form-container">
        <h3 class="form-title">Add New Product</h3>
        <form action="add-product" method="post">
            <label>Product Name:</label>
            <input type="text" name="productName" required>

            <label>Brand:</label>
            <input type="text" name="brand" required>

            <label>Category:</label>
            <input type="text" name="brandCategory" required>

            <label>Price:</label>
            <input type="number" step="0.01" name="price" required>

            <label>Stock:</label>
            <input type="number" name="stock" required>

            <button type="submit" class="btn-submit">➕ Add Product</button>
        </form>
    </div>
</body>
</html>