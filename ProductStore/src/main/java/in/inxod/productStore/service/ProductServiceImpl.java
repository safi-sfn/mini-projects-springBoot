package in.inxod.productStore.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.inxod.productStore.model.Product;
import in.inxod.productStore.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository repo;
	
	
	@Override
	public List<Product> getAllProduct() {
		
		return repo.findAll();
	}
	
	@Override
	public List<Product> getProductsByCategory(String category) {
	    return repo.findByBrandCategory(category);
	}
	
	
	@Override
	public List<String> getAllCategories() {
	    return repo.findDistinctCategories();
	}

	@Override
	public Product addProduct(Product product) {
		
		return repo.save(product);
	}

	@Override
	public List<Product> getProductByBrand(String brand) {
		
		return repo.findByBrand(brand);
	}

	@Override
	public List<String> getAllBrand() {
		
		return repo.findDistinctBrand();
	}

	@Override
	public void deleteProductRecord(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Product getProductById(Integer id) {
		
		Optional<Product> optional = repo.findById(id);
		return optional.get();		
	}


	
	
	

	
}










