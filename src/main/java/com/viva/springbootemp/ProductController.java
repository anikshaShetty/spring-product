package com.viva.springbootemp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
@RequestMapping(path="/api")
public class ProductController {

	@Autowired
	ProductRepo repo;
	
	
	@RequestMapping(path="/products" , method=RequestMethod.GET)
	public List<Product> findAllCourses(){
		List<Product> products = repo.findAll();
		return products;
	}
	
	@RequestMapping(path="/products/{name}" , method=RequestMethod.GET)
	public ResponseEntity<Product> findProductByName(@PathVariable("name") String name){
		Product product = repo.findByName(name);
		System.out.println(product);
		ResponseEntity<Product> re = null;
		if(product == null){
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return re;
		}
		re = new ResponseEntity<>(product, HttpStatus.OK);
		return re;
	}
	
	
	
	@RequestMapping(path="/products/{id}" , method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable("id") int id){
		repo.deleteById(id);
	}
	
	
	@RequestMapping(path="/products/{id}" , method=RequestMethod.GET)
	public String updatingProduct(@PathVariable("id") int id){
		return "update";
		
	}
	
	@RequestMapping(path="/products" , method=RequestMethod.POST)
	public ResponseEntity<Void> addCourse(@RequestBody Product product){
		System.out.println(product);
		repo.save(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path="/products/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> updateProduct(@PathVariable("id") int id,@RequestBody Product product)
	{
		Optional<Product> prod=repo.findById(id);
		if(!prod.isPresent())
			return ResponseEntity.notFound().build();
		product.setId(id);
		repo.save(product);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
