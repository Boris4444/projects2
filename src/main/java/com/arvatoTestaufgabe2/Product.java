package com.arvatoTestaufgabe2;

public class Product {
	
	private String name;
	private String countryOfOrigin;
	private Float price;
	private boolean isFragile;
	private int timesPurchased;
	
	public Product(String name, String countryOfOrigin, Float price, boolean isFragile, int timesPurchased) {		
		this.name = name;
		this.countryOfOrigin = countryOfOrigin;
		this.price = price;
		this.isFragile = isFragile;
		this.timesPurchased = timesPurchased;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public boolean isFragile() {
		return isFragile;
	}
	public void setFragile(boolean isFragile) {
		this.isFragile = isFragile;
	}
	public int getTimesPurchased() {
		return timesPurchased;
	}
	public void setTimesPurchased(int timesPurchased) {
		this.timesPurchased = timesPurchased;
	}
			
}
