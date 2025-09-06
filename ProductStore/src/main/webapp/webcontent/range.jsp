<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css"></style>
</head>
<body style="background: #2bcbba">
	<div
		style="max-width: 350px; margin: 40px auto; padding: 20px; background: #f9f9f9; 
		       border: 2px solid #ddd; border-radius: 10px; 
		       box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
		       font-family: Arial, sans-serif;">

		<h2 style="text-align: center; margin-bottom: 20px; color: #333;">
			Enter Price Range</h2>

		<form action="filter-product" method="post">
			<label
				style="display: block; margin: 10px 0 5px; font-weight: bold; color: #555;">
				Min Price: </label> <input type="number" name="minPrice" min="0" required
				style="width: 100%; padding: 8px 10px; border: 1px solid #ccc; border-radius: 6px; font-size: 14px; outline: none; transition: border-color 0.3s ease;">

			<label
				style="display: block; margin: 10px 0 5px; font-weight: bold; color: #555;">
				Max Price: </label> <input type="number" name="maxPrice" min="0" required
				style="width: 100%; padding: 8px 10px; border: 1px solid #ccc; border-radius: 6px; font-size: 14px; outline: none; transition: border-color 0.3s ease;">

			<button type="submit"
				style="margin-top: 15px; width: 100%; padding: 10px; background: #007bff; border: none; color: white; font-size: 16px; border-radius: 6px; cursor: pointer; transition: background 0.3s ease;">
				OK</button>
		</form>
	</div>

</body>
</html>