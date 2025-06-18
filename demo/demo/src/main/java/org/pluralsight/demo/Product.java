package org.pluralsight.demo;

public class Product implements Printable{

   int productId;
   String name;
   String category;
   double price;

   public Product (int productId, String name, String category, double price) {
	  this.productId = productId;
	  this.name = name;
	  this.category = category;
	  this.price = price;
   }

   //region getters and setters
   public int getProductId() {
	  return productId;
   }

   public void setProductId(int productId) {
	  this.productId = productId;
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

   public double getPrice() {
	  return price;
   }

   public void setPrice(double price) {
	  this.price = price;
   }
   //endregion

   public void print() {
	  System.out.println("-----PRODUCT-----");
	  System.out.println("Product ID: " + this.productId);
	  System.out.println("Product Name: " + this.name);
	  System.out.println("Category: " + this.category);
	  System.out.println("Price: $" + this.price);
   }
}
