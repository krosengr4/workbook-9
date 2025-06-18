package org.pluralsight.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SimpleProductDao implements ProductDao{

   private final ArrayList<Product> productsList;

   public SimpleProductDao() {
	  productsList = new ArrayList<>();

	  this.productsList.add(new Product(10, "Chocolate Chip Cookies", "Food", 11.99));
	  this.productsList.add(new Product(11, "Shampoo", "Bathroom", 8.99));
	  this.productsList.add(new Product(12, "Kev's Kolaches", "Food", 8.99));
	  this.productsList.add(new Product(13, "Madden 13", "Video Games", 8.99));
   }

   public void addProduct(Product product) {
	  productsList.add(product);
   }

   public ArrayList<Product> getAll() {
	  return productsList;
   }

}
