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

   public Category addCategory(Category category) {

	  String categoryName = category.getCategoryName();
	  String query = "INSERT INTO categories (CategoryName) VALUES (?);";

	  Category returnCategory = new Category();
	  returnCategory.setCategoryName(categoryName);

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		 statement.setString(1, categoryName);

		 int results = statement.executeUpdate();

		 try (ResultSet keys = statement.getGeneratedKeys()) {
			while(keys.next()) {
			   returnCategory.setCategoryId(keys.getInt(1));
			}
		 }

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
	  return returnCategory;
   }

   public void updateCategory(int categoryId, Category category) {

	  String categoryName = category.getCategoryName();
	  String query = "UPDATE categories SET categoryName = ? WHERE CategoryID = ?";

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query);
		 statement.setString(1, categoryName);
		 statement.setInt(2, categoryId);

		 int rows = statement.executeUpdate();

		 System.out.println("Rows updated: " + rows);

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
   }

   public void deleteCategory(int categoryId) {
	  String query = "DELETE FROM categories WHERE CategoryID = ?;";

	  try(Connection conn = dataSource.getConnection()){
		 PreparedStatement statement = conn.prepareStatement(query);
		 statement.setInt(1, categoryId);
		 int rows = statement.executeUpdate();

		 if(rows != 0) {
			System.out.println("Success! The category was deleted!");
		 } else {
			System.err.println("Error! Could not delete category!!!");
		 }

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
   }
}
