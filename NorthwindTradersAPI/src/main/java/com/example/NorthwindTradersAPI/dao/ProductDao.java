package com.example.NorthwindTradersAPI.dao;

import com.example.NorthwindTradersAPI.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface ProductDao {

   ArrayList<Product> getAllProducts();
   Product getById (int productID);
   Product addProduct(Product product);
   void updateProduct(int productId, Product product);
}

