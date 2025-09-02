package in.inxod.productStore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer productId;
	@Column(name="name")
	private String productName;
	private String brand;
	private Double price;
	private Integer stock;
	@Column(name="category")
	private String brandCategory;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getBrandCategory() {
		return brandCategory;
	}
	public void setBrandCategory(String brandCategory) {
		this.brandCategory = brandCategory;
	}
	public Product(String productName, String brand, Double price, Integer stock, String brandCategory) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
		this.brandCategory=brandCategory;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
