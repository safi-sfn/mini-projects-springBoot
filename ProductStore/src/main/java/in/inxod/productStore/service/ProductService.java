package in.inxod.productStore.service;


import java.util.List;

import in.inxod.productStore.model.Product;

public interface ProductService {
	
	
	List<Product> getAllProduct();
	
	List<Product> getProductsByCategory(String category);
	
	List<String> getAllCategories();
	
	Product addProduct(Product product);

	
	
}
