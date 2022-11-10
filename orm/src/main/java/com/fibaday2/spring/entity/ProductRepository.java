package com.fibaday2.spring.entity;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends CrudRepository <Product, Long> {
	@Query("select p from Product as p where p.salesPrice >= :minPrice ") 
	List<Product> findAllBySalesPriceMin(@Param("minPrice") double minPrice);
}
