package com.jaya.ecom;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String brand;
	private BigDecimal price;
	private String category;
	@DateTimeFormat
	private Date RELEASEDATE;
	private Boolean PRODUCTAVAILABLE;
	private int STOCKQUANTITY;
	private String imageName;
	private String imageType;
	@Lob 
	private byte[] imageData;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getRelese_Date() {
		return RELEASEDATE;
	}
	public void setRelese_Date(Date relese_Date) {
		RELEASEDATE = relese_Date;
	}
	public Boolean getAvailable() {
		return PRODUCTAVAILABLE;
	}
	public void setAvailable(Boolean available) {
		this.PRODUCTAVAILABLE = available;
	}
	public int getQuantity() {
		return STOCKQUANTITY;
	}
	public void setQuantity(int quantity) {
		this.STOCKQUANTITY = quantity;
	}
	public String getImagename() {
		return imageName;
	}
	public void setImagename(String imagename) {
		this.imageName = imagename;
	}
	public String getImagetype() {
		return imageType;
	}
	public void setImagetype(String imagetype) {
		this.imageType = imagetype;
	}
	public byte[] getImagedata() {
		return imageData;
	}
	public void setImagedata(byte[] imagedata) {
		this.imageData = imagedata;
	}
}


