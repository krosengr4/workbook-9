package com.example.NorthwindTradersAPI.dao;

import com.example.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao{

   private final DataSource dataSource;

   @Autowired
   public JdbcProductDao(DataSource dataSource) {
	  this.dataSource = dataSource;
   }

   public List<Product> getAllProducts() {
	  List<Product> productsList = new ArrayList<>();
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

}
