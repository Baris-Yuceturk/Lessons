package com.fibabootcamplesson01.spring.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fibabootcamplesson01.spring.Product;

@Controller
public class ProductController {

	@GetMapping("/product/get") // Default is value, can be declared as path = "/product"
	@ResponseBody
	public String getProduct() {
		long productId = 301;
		String url = "http://localhost:8080/api/product/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(url, Product.class);
		System.out.println("ürün:  " + product.getProductName());
		return "Edinme başarılı " + product.getProductName() + " " + product.getSalesPrice();
	}

	@GetMapping("/product/post") // Default is value, can be declared as path = "/product"
	@ResponseBody
	public String postProduct() {
		Product product = new Product(0, "Fritöz", 540);
		String url = "http://localhost:8080/api/product";
		RestTemplate restTemplate = new RestTemplate();
		Product result = restTemplate.postForObject(url, product, Product.class);
		return "Yollama başarılı " + result.getProductId();
	}

	@GetMapping("/product/put") // Default is value, can be declared as path = "/product"
	@ResponseBody
	public String putProduct() {
		Product product = new Product(302, "Tablet Bilgisayar", 5465);
		String url = "http://localhost:8080/api/product";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Product>(product), void.class); // exchange is the most recent version. Older one is like putForObject
		return "Koyma başarılı ";
	}

	@GetMapping("/product/delete") // Default is value, can be declared as path = "/product"
	@ResponseBody
	public String deleteProduct() {
		long productId = 303;
		String url = "http://localhost:8080/api/product/"+productId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme başarılı ";
	}
	
}
