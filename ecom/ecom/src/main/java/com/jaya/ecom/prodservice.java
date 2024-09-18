package com.jaya.ecom;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class prodservice {

	@Autowired
	prodrepo repo;
	
	public List<product> getprods() {
		return repo.findAll();
	}
	public product getprodbyid(int id) {
		
		return repo.findById(id).orElse(new product());
	}
	
	
	public product addprod(product product, MultipartFile imagefile) throws IOException {
		
		product.setImagename(imagefile.getOriginalFilename());
		product.setImagetype(imagefile.getContentType());
		product.setImagedata(imagefile.getBytes());
		
		return repo.save(product);
	}
	public product updateprod(int id, product product, MultipartFile imagefile) throws IOException {
		
		product.setImagedata(imagefile.getBytes());
		product.setImagename(imagefile.getOriginalFilename());
		product.setImagetype(imagefile.getContentType());
		return repo.save(product);
		
	}
	public void deleteprod(int id) {
		repo.deleteById(id);
		
	}
	public List<product> searchProducts(String keyword) {
		return repo.searchProducts(keyword);
	}

}
