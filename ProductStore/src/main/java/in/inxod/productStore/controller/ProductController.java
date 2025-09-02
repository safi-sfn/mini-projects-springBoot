package in.inxod.productStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.inxod.productStore.model.Product;
import in.inxod.productStore.service.ProductServiceImpl;

@Controller
@RequestMapping("/ps")
public class ProductController {

	@Autowired
	private ProductServiceImpl service;

	
	// Show-All-Products
	@GetMapping("/show-product")
	public String showAllProduct(Model model) {
		List<Product> allProducts = service.getAllProduct();
		model.addAttribute("products", allProducts);
		
		List<String> categories = service.getAllCategories();
	    model.addAttribute("categories", categories);
	    
	    List<String> brands = service.getAllBrand();
		model.addAttribute("brands", brands);
		return "dashboard";
	}
	

	@GetMapping("/category")
	public String showByCategory(@RequestParam("category") String category, Model model) {
		// get product By Category
	    List<Product> products = service.getProductsByCategory(category);
	    model.addAttribute("products", products);
	
	 // Show All categories -> eg- Mobile,Electronic
	    List<String> categories = service.getAllCategories();
	    model.addAttribute("categories", categories);
	    
	    List<String> brands = service.getAllBrand();
		model.addAttribute("brands", brands);
	
	    return "dashboard";
	}
	
	@GetMapping("/brand")
	public String showByBrand(@RequestParam("brand")String brand, Model model) {
		// get product By Brand
		List<Product> products = service.getProductByBrand(brand);
		model.addAttribute("products", products);
		
		// Show All brands -> eg- Apple,HP
		List<String> brands = service.getAllBrand();
		model.addAttribute("brands", brands);
		
		List<String> categories = service.getAllCategories();
	    model.addAttribute("categories", categories);
	    
		
		return "dashboard";
	}
	
	@GetMapping("/new-product")
	public String showForm(Model model) {
		model.addAttribute("customer", new Product());
		return "addProduct";
	}
	
	@PostMapping("/add-product")
	public String addProduct(Model model ,Product product) {
		// Adding New product
		Product p = service.addProduct(product);
		model.addAttribute("newProduct", p);
		return "redirect:/ps/show-product";
	}
	
	@GetMapping("/delete-data")
	public String deleteProduct(@RequestParam("productId")Integer id) {
		// Delete the Product
		service.deleteProductRecord(id);
		return "redirect:/ps/show-product";
	}
	
	@GetMapping("/update-data")
	public String updateData(@RequestParam("productId")Integer id , Model model) {
		// Getting product by productId
		Product pr = service.getProductById(id);
		model.addAttribute("product", pr);
		return "updateProduct";
	}
	
	
	
	
	
	

}
