package in.inxod.productStore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.inxod.productStore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	// Custom Finder method
	
	List<Product> findAll();
	List<Product> findByBrandCategory(String category);
	
	@Query("SELECT DISTINCT p.brandCategory FROM Product p")
	List<String> findDistinctCategories();

}
