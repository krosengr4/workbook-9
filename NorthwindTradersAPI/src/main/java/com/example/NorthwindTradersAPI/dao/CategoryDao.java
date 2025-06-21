package com.example.NorthwindTradersAPI.dao;

import com.example.NorthwindTradersAPI.models.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface CategoryDao {

   ArrayList<Category> getAllCategories();
   Category getById(int categoryId);
   Category addCategory(Category category);
   void updateCategory(int categoryId, Category category);
//   void deleteCategory(int categoryId);

}
