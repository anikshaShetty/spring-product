package com.viva.springbootemp;

//import java.sql.Date;
import java.util.Date;
//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	private String name;
	
	private String category;	
	private Double price;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getDate() {
		return date;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd")
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", price=" + price + ", date=" + date + "]";
	}
	
	
	
	
}
