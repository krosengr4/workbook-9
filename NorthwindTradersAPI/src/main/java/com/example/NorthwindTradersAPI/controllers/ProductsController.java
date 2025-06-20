package com.example.NorthwindTradersAPI.controllers;

import com.example.NorthwindTradersAPI.dao.ProductDao;
import com.example.NorthwindTradersAPI.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

   private final ProductDao productDao;

   @Autowired
   public ProductsController(ProductDao productDao) {
	  this.productDao = productDao;
   }

   @GetMapping(path = "/products")
   public List<Product> getAllProducts() {
	  return productDao.getAllProducts();
   }

   @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
   public Product getProductById(@PathVariable int productId) {
	  return productDao.getById(productId);
   }

}
