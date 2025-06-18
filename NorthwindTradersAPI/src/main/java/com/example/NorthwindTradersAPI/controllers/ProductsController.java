package com.example.NorthwindTradersAPI.controllers;

import com.example.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

   @RequestMapping(path = "/products", method = RequestMethod.GET)
   public List<Product> getAllProducts() {
	  List<Product> productsList = new ArrayList<>();

	  productsList.add(new Product(1, "Journal", 1, 27.59));
	  productsList.add(new Product(2, "Cookies", 3, 12.99));
	  productsList.add(new Product(3, "Baked Beans", 2, 8.79));
	  productsList.add(new Product(4, "Brownies", 3, 9.29));

	  return productsList;
   }

   @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
   public List<Product> getProduct(@PathVariable int productId) {
	  List<Product> productsList = new ArrayList<>();
	  productsList.add(new Product(1, "Journal", 1, 27.59));
	  productsList.add(new Product(2, "Cookies", 3, 12.99));
	  productsList.add(new Product(3, "Baked Beans", 2, 8.79));
	  productsList.add(new Product(4, "Brownies", 3, 9.29));

	  return productsList;
   }

}
