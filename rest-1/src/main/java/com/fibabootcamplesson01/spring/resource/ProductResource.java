package com.fibabootcamplesson01.spring.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fibabootcamplesson01.spring.Product;
import com.fibabootcamplesson01.spring.service.ProductService;

// Rest controller for object example instead of string

@RestController
public class ProductResource {

	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/api/product/{id}") // Default is value, can be declared as path = "/product"
	public Product getProduct(@PathVariable("id") long productId) {
		Product product = productService.find(productId);
		return product;
	}

	@GetMapping("/api/products") // This method will display the array list instead of single object
	public List<Product> getProducts() {
		List<Product> productList = productService.findAll();
		return productList;
	}

	@PostMapping("/api/product") // older method is like : @RequestMapping(method = RequestMethod.POST, "Uri")
	public Product postProduct(@RequestBody Product product) {
		product.setProductId(301);
		productService.createProduct(product);
		return product;
	}

	@PutMapping("/api/product")  // This one updates the requested product
	public void putProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}

	@DeleteMapping("/api/product/{id}" )  // There is two way to use delete. Object can be found by a parameter or RequestModel can be used
	public void deleteProduct(@PathVariable("id")long productId) {
		productService.deleteProduct(productId);
	}
	
}