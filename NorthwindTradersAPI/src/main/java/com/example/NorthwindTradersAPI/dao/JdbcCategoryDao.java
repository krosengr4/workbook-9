package com.example.NorthwindTradersAPI.dao;

import com.example.NorthwindTradersAPI.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;

@Component
public class JdbcCategoryDao implements CategoryDao{

   private final DataSource dataSource;

   @Autowired
   public JdbcCategoryDao(DataSource dataSource) {
	  this.dataSource = dataSource;
   }

   public ArrayList<Category> getAllCategories() {
	  ArrayList<Category> categoriesList = new ArrayList<>();
	  String query = "SELECT * FROM categories;";

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query);
		 ResultSet results = statement.executeQuery();

		 while (results.next()) {
			int categoryId = results.getInt("CategoryID");
			String categoryName = results.getString("CategoryName");

			Category category = new Category(categoryId, categoryName);
			categoriesList.add(category);
		 }

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
	  return categoriesList;
   }

   public Category getById(int categoryId) {
	  Category category = new Category();
	  String query = "SELECT * FROM categories WHERE CategoryID = ?;";

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query);
		 statement.setInt(1, categoryId);

		 ResultSet results = statement.executeQuery();
		 while(results.next()) {
			int dbCategoryId = results.getInt("CategoryID");
			String categoryName = results.getString("CategoryName");
			category = new Category(dbCategoryId, categoryName);
		 }

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
	  return category;
   }
}
