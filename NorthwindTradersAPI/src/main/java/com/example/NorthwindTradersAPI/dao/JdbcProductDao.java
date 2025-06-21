package com.example.NorthwindTradersAPI.dao;

import com.example.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Component
public class JdbcProductDao implements ProductDao{

   private final DataSource dataSource;

   @Autowired
   public JdbcProductDao(DataSource dataSource) {
	  this.dataSource = dataSource;
   }

   public ArrayList<Product> getAllProducts() {
	  ArrayList<Product> productsList = new ArrayList<>();
	  String query = "SELECT * FROM products";

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query);
		 ResultSet results = statement.executeQuery();

		 while(results.next()) {
			int productID = results.getInt("ProductID");
			String productName = results.getString("ProductName");
			int categoryId = results.getInt("CategoryID");
			double unitPrice = results.getDouble("UnitPrice");
			Product product = new Product(productID, productName, categoryId, unitPrice);

			productsList.add(product);
		 }

	  } catch(SQLException e) {
		 throw new RuntimeException(e);
	  }

	  return productsList;
   }

   public Product getById(int productId) {
	  Product product = new Product();
	  String query = "SELECT * FROM products WHERE ProductID = ?";

	  try(Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query);
		 statement.setInt(1, productId);

		 ResultSet results = statement.executeQuery();
		 while (results.next()) {
			int dbProductId = results.getInt("ProductID");
			String productName = results.getString("ProductName");
			int categoryId = results.getInt("CategoryID");
			double unitPrice = results.getDouble("UnitPrice");

			product = new Product(dbProductId, productName, categoryId, unitPrice);
		 }

	  } catch(SQLException e) {
		 throw new RuntimeException(e);
	  }
	  return product;
   }

   public Product addProduct(Product product) {
	  String productName = product.getName();
	  int categoryId = product.getCategoryId();
	  double unitPrice = product.getUnitPrice();

	  String query = "INSERT INTO products (ProductName, CategoryID, UnitPrice)" +
							 "VALUES (?, ?, ?);";
	  Product returnProduct = new Product();
	  returnProduct.setName(productName);
	  returnProduct.setCategoryId(categoryId);
	  returnProduct.setUnitPrice(unitPrice);

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		 statement.setString(1, productName);
		 statement.setInt(2, categoryId);
		 statement.setDouble(3, unitPrice);

		 int results = statement.executeUpdate();

		 try(ResultSet keys = statement.getGeneratedKeys()) {
			while(keys.next()) {
			   returnProduct.setProductId(keys.getInt(1));
			}
		 }

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
	  return returnProduct;
   }

   public void updateProduct(int productId, Product product) {
	  String productName = product.getName();
	  int categoryId = product.getCategoryId();
	  double unitPrice = product.getUnitPrice();

	  String query = "UPDATE products SET ProductName = ?, CategoryID = ?, UnitPrice = ? WHERE productID = ?;";

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query);
		 statement.setString(1, productName);
		 statement.setInt(2, categoryId);
		 statement.setDouble(3, unitPrice);
		 statement.setInt(4, productId);

		 int rows = statement.executeUpdate();

		 if(rows != 0) {
			System.out.println("Success! Rows updated: " + rows);
		 } else {
			System.err.println("ERROR! Did not update product!!!");
		 }

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
   }

   public void deleteProduct(int productId){
	  String query = "DELETE FROM products WHERE ProductID = ?;";

	  try (Connection conn = dataSource.getConnection()) {
		 PreparedStatement statement = conn.prepareStatement(query);
		 statement.setInt(1, productId);

		 int rows = statement.executeUpdate();
		 if(rows != 0) {
			System.out.println("Success! The product was deleted!");
		 } else {
			System.err.println("Error! Could not delete product!!!");
		 }

	  } catch (SQLException e) {
		 throw new RuntimeException(e);
	  }
   }

}
