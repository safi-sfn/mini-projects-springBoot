package in.inxod.productStore.service;


import java.util.List;

import in.inxod.productStore.model.Product;

public interface ProductService {
	
	// Show-All-Products
	List<Product> getAllProduct();
	
	// Show product By Category
	List<Product> getProductsByCategory(String category);
	// Show All categories -> eg- Mobile,Electronic
	List<String> getAllCategories();
	
	// Show product By Brand
	List<Product> getProductByBrand(String brand);
	// Show All brands -> eg- Apple,HP
	List<String> getAllBrand();
	
	// Adding New product
	Product addProduct(Product product);
	
	// Getting product by productId for Updating the Product
	Product getProductById(Integer id);

	// Delete the Product
	void deleteProductRecord(Integer id);

	
	
}
