package com.jaya.ecom;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface prodrepo extends JpaRepository<product, Integer> {

	@Query("SELECT p from product p where "+
			"LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
			"LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
			"LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
			"LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<product> searchProducts(String keyword);
	
	

}
