package in.inxod.productStore.service;


import java.util.List;

import in.inxod.productStore.model.Product;

public interface ProductService {
	
	
	List<Product> getAllProduct();
	
	List<Product> getProductsByCategory(String category);
	List<String> getAllCategories();
	
	List<Product> getProductByBrand(String brand);
	List<String> getAllBrand();
	
	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	Product getProductById(Integer id);
	
	void deleteProductRecord(Integer id);

	
	
}
