package com.arvatoTestaufgabe2;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neovisionaries.i18n.CountryCode;

@RestController
public class ProductController {
	
	//@PostMapping(path = "/text/analyze")
	@RequestMapping(value = "/text/analyze", method = RequestMethod.POST)
	public String analyzeProducts(@RequestBody List<Product> productlist) {
		JSONObject obj = new JSONObject();
		
		// Vergleichswerte
		String mostExpensiveProduct = productlist.get(0).getName();
		Float highestPrice = productlist.get(0).getPrice();
		String cheapestProduct = productlist.get(0).getName();
		Float cheapestPrice = productlist.get(0).getPrice();
		String mostPopularProduct = productlist.get(0).getName();
		int highestTimesPurchased = productlist.get(0).getTimesPurchased();
		JSONArray germanProducts = new JSONArray();
		JSONArray chineseProducts = new JSONArray();
		boolean containsFragileProducts = false;
		
		
		for(Product product : productlist) {			
			
			// Überprüfung ob höchster Preis
			if(product.getPrice() > highestPrice) {
				highestPrice = product.getPrice();
				mostExpensiveProduct = product.getName();
			}
			
			// Überprüfung ob niedrigster Preis
			if(product.getPrice() < cheapestPrice) {
				cheapestPrice = product.getPrice();
				cheapestProduct = product.getName();
			}
			
			// Überprüfung ob höchste beliebtheit
			if(product.getTimesPurchased() > highestTimesPurchased) {
				highestTimesPurchased = product.getTimesPurchased();
				mostPopularProduct = product.getName();
			}

			// Überprüfung ob deutsches Produkt
			if(product.getCountryOfOrigin().equals(CountryCode.getByCode("DE").getAlpha2())) {
				germanProducts.add(product.getName());
			}
			
			// Überprüfung ob chinesisches Produkt
			if(product.getCountryOfOrigin().equals(CountryCode.getByCode("CN").getAlpha2())) {
				germanProducts.add(product.getName());
			}
			
			// Überprüfung ob fragile Ware dabei ist
			if(product.isFragile()) {
				containsFragileProducts = true;
			}
		}
		
		// JSON Ausgabeobjekt zusammenbauen
		obj.put("mostExpensiveProduct", mostExpensiveProduct);
		obj.put("cheapestProduct", cheapestProduct);
		obj.put("mostPopularProduct", mostPopularProduct);
		obj.put("germanProducts", germanProducts);
		obj.put("chineseProducts", chineseProducts);
		obj.put("containsFragileProducts", containsFragileProducts);
		
		return obj.toString();
	}
	
}
