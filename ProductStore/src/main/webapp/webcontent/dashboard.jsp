<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Dashboard</title>
<link rel="stylesheet" type="text/css" href="<spring:url value='/css/dashboard-style.css' />">
</head>
<body>

<div class="container">

    <!-- Dashboard Card -->
    <div class="dashboard-card">
        <h2>📦 Product Store Dashboard</h2>
        <div class="button-group">
            <a href="show-product" class="btn">Show All Products</a>
            <a href="min-price" class="btn">Min Price Product</a>
            <a href="max-price" class="btn">Max Price Product</a>
            <a href="price-range" class="btn">Products by Price Range</a>
          
             <!-- Dropdown for Brand -->
            <form action="brand" method="get" class="dropdown-form">
                <select name="brand" onchange="this.form.submit()">
						<option value="" disabled
							<c:if test="${empty param.brand}">selected</c:if>>--
							Select Brand --</option>
						<c:forEach var="b" items="${brands}">
                        <option value="${b}"
                           <c:if test="${param.brand == b}">selected</c:if>>
                           ${b}</option>
                    </c:forEach>
                </select>
            </form>
            
            <!-- Dropdown for category -->
            <form action="category" method="get" class="dropdown-form">
                <select name="category" onchange="this.form.submit()">
						<option value="" disabled
							<c:if test="${empty param.category}">selected</c:if>>--
							Select Category --</option>
						<c:forEach var="pc" items="${categories}">
                        <option value="${pc}"
                           <c:if test="${param.category == pc}">selected</c:if>>
                           ${pc}</option>
                    </c:forEach>
                </select>
            </form>

            <a href="${pageContext.request.contextPath}/ps/new-product" class="btn btn-add">➕ Add New Product</a>
        </div>
    </div>

    <!-- Product Table -->
    <div class="product-list">
         <h2>📦 Product Store</h2>
        <table>
            <thead>
                <tr>
           
                    <th>Product Name</th>
                    <th>Brand</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${products}">
                		<c:url var="UpdateLink" value="/ps/update-data">
                        	<c:param name="productId" value="${p.productId}"></c:param>
                        </c:url>
                
                		<c:url var="DeleteLink" value="/ps/delete-data">
                        	<c:param name="productId" value="${p.productId}"></c:param>
                        </c:url>
               
                    <tr>
                        <td>${p.productName}</td>
                        <td>${p.brand}</td>
                        <td>${p.brandCategory}</td>
                        <td>₹${p.price}</td>
                        <td>${p.stock}</td>
                        <td>
                            <a href="${UpdateLink}" class="btn btn-edit">✏ Edit</a>
                            <a href="${DeleteLink}" class="btn btn-delete" onclick="return confirm('Are you sure to delete?')">🗑 Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>
