package com.example.NorthwindTradersAPI.controllers;

import com.example.NorthwindTradersAPI.dao.CategoryDao;
import com.example.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

   @RequestMapping(path = "/categories", method = RequestMethod.POST)
   @ResponseStatus(value = HttpStatus.CREATED)
   public Category addCategory(@RequestBody Category category) {

	  return categoryDao.addCategory(category);
   }

   @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.PUT)
   public void updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
	  categoryDao.updateCategory(categoryId, category);
   }

   @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.DELETE)
   public void deleteCategory(@PathVariable int categoryId) {
	  categoryDao.deleteCategory(categoryId);
   }

}
