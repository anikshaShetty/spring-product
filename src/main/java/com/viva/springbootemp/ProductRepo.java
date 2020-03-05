package com.viva.springbootemp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
		public Product findByName(String name);
		
}
