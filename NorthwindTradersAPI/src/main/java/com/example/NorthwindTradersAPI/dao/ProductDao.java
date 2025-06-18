package com.example.NorthwindTradersAPI.dao;

import com.example.NorthwindTradersAPI.models.Product;

import java.util.ArrayList;

public interface ProductDao {

   ArrayList<Product> getAllProducts();
   void addProduct(Product product);
}
