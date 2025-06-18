package com.example.NorthwindTradersAPI.controllers;

import com.example.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

   @RequestMapping(path = "/categories", method = RequestMethod.GET)
   public List<Category> getAllCategories() {
	  List<Category> categoriesList = new ArrayList<>();
	  categoriesList.add(new Category(1, "Home and Office"));
	  categoriesList.add(new Category(2, "Canned Foods"));
	  categoriesList.add(new Category(3, "Dessert Foods"));

	  return categoriesList;
   }

   @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
   public Category getCategory(@PathVariable int categoryId) {
	  List<Category> categoriesList = new ArrayList<>();
	  categoriesList.add(new Category(1, "Home and Office"));
	  categoriesList.add(new Category(2, "Canned Foods"));
	  categoriesList.add(new Category(3, "Dessert Foods"));

	  for (Category c : categoriesList) {
		 if (c.getCategoryId() == categoryId) {
			return c;
		 }
	  }
	  return null;
   }

}
