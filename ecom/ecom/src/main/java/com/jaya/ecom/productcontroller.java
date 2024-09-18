package com.jaya.ecom;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api")
public class productcontroller {

	@Autowired
	prodservice service;
	
	@GetMapping("/")
	public String greet() { 
		return "Nagraj Bhai";
	}
	
	@GetMapping("/products")
	public List<product> getprod(){
		return service.getprods();
	}
	
	@GetMapping("/product/{id}")
	public product getprodbyid(@PathVariable int id) {
		return service.getprodbyid(id);
	}
	
	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestPart product product, @RequestPart MultipartFile imageFile){
		try {
			product product1=service.addprod(product,imageFile);
			
			return new ResponseEntity<>(product1,HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
	
	@GetMapping("/product/{productId}/image")
	public ResponseEntity<byte[]> getimagebyid(@PathVariable int productId){
		product product=service.getprodbyid(productId);
		byte[] imageFile=product.getImagedata();
		
		return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImagetype())).body(imageFile);
		
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<String> updateprod(@PathVariable int id,@RequestPart product product, @RequestPart MultipartFile imageFile){
		product product1 = null;
		try {
			product1 = service.updateprod(id,product,imageFile);
		} catch (IOException e) {
			
			return new ResponseEntity<>("Failed to update",HttpStatus.BAD_REQUEST);
		}
			
		if(product1!=null) {
			return new ResponseEntity<>("updated",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("failed to update",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteprod(@PathVariable int id){
		product prod=service.getprodbyid(id);
		
		if(prod!=null) {
			service.deleteprod(id);
			
			return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Product not found",HttpStatus.OK);
		}
	}
	
	@GetMapping("/products/search")
	public ResponseEntity<List<product>> searchprods(@RequestParam String keyword){
		List<product> products=service.searchProducts(keyword);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
	
}
