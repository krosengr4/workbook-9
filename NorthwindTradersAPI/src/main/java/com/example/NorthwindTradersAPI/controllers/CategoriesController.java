package com.example.NorthwindTradersAPI.controllers;

import com.example.NorthwindTradersAPI.dao.CategoryDao;
import com.example.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

   private final CategoryDao categoryDao;

   @Autowired
   public CategoriesController(CategoryDao categoryDao) {
	  this.categoryDao = categoryDao;
   }

   @RequestMapping(path = "/categories", method = RequestMethod.GET)
   public List<Category> getAllCategories() {
	  return categoryDao.getAllCategories();
   }

   @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
   public Category getCategory(@PathVariable int categoryId) {
	  return categoryDao.getById(categoryId);
   }

}
