package com.zero2one.yuri.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Product;

@RestController
@RequestMapping("/products")

public class ProductsController {
	
	//http://localhost:8080/products?name=Yuri&last=Achermann
	
	private Map< String , Product > products = new HashMap<>();
	
	public ProductsController() {
		Product celular = new Product();
		celular.setId( "1A" );
		celular.setName( "MI9" );
		celular.setDescription( "celular da Xiaomi" );
		celular.setPrice( 1999.99 , 10.0 );
		
		Product notebook = new Product();
		celular.setId( "1B" );
		celular.setName( "Dell" );
		celular.setDescription( "notebook i9" );
		celular.setPrice( 9999.99 , 10D );

		products.put( celular.getId() , celular );
		products.put( notebook.getId() , notebook );
	}
	
	@GetMapping
	/*
	public String get( @RequestParam( value = "name" , required = true ) String name ,
			@RequestParam( value = "last" , required = false ) String last ) {
		if( name.equals( "João" ) ) {
			return "João não pode acessar!";
		}
		if( last.equals( null ) ) {
			return name;
		}
		return name+" "+last;
	}
	*/
	
	public Collection<Product> get( ) {
		return products.values();
	}
	
	@GetMapping("/{id}")
	public Product getById( @PathVariable("id") String id ) {
		return products.get( id );
	}
	
	@PostMapping
	public Product create( @RequestBody Product product ) {
		products.put( product.getId() , product );
		return product;
	}
	
	

}
