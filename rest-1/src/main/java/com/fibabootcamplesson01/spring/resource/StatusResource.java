package com.fibabootcamplesson01.spring.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fibabootcamplesson01.spring.Product;

@RestController
public class StatusResource {

	@GetMapping("/status/ok/{id}")
	public ResponseEntity<?> getOk(@PathVariable("id") long productId) {
		Product product = new Product(productId, "Cep Telefonu", 1450);
		// return new ResponseEntity<>(product, HttpStatus.OK);
		// return ResponseEntity.status(HttpStatus.OK) 		  // alternative solution 1
		// .body(product);
		 return ResponseEntity								 
		 .ok()
		 .body(product);
		//return ResponseEntity.ok(product);				// alternative solution 2
	}

	@GetMapping("/status/notfound/{id}")
	public ResponseEntity<?> getNotFound(@PathVariable("id") long productId) {
		Product product = new Product(productId, "Cep Telefonu", 1450);
		if (productId == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Ürün bulunamadı");
		}
		return ResponseEntity.ok(product);
	}

}
