package com.example.NorthwindTradersAPI.models;

import org.springframework.stereotype.Component;

@Component
public class Product {

   int productId;
   String name;
   int categoryId;
   double unitPrice;

   public Product(int productId, String name, int categoryId, double unitPrice) {
	  this.productId = productId;
	  this.name = name;
	  this.categoryId = categoryId;
	  this.unitPrice = unitPrice;
   }

   public Product() {
   }

   //region getters and setters
   public void setProductId(int productId) {
	  this.productId = productId;
   }

   public void setName(String name) {
	  this.name = name;
   }

   public void setCategoryId(int categoryId) {
	  this.categoryId = categoryId;
   }

   public void setUnitPrice(double unitPrice) {
	  this.unitPrice = unitPrice;
   }

   public int getProductId() {
	  return productId;
   }

   public String getName() {
	  return name;
   }

   public int getCategoryId() {
	  return categoryId;
   }

   public double getUnitPrice() {
	  return unitPrice;
   }
   //endregion
}
