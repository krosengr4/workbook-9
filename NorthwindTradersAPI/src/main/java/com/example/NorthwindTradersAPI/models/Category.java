package com.example.NorthwindTradersAPI.models;

public class Category {

   int categoryId;
   String categoryName;

   public Category(int categoryId, String categoryName) {
	  this.categoryId = categoryId;
	  this.categoryName = categoryName;
   }

   public Category() {}

   //region getters and setter
   public void setCategoryId(int categoryId) {
	  this.categoryId = categoryId;
   }

   public void setCategoryName(String categoryName) {
	  this.categoryName = categoryName;
   }

   public int getCategoryId() {
	  return categoryId;
   }

   public String getCategoryName() {
	  return categoryName;
   }
   //endregion
}
