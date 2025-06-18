package org.pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductController {

   ProductDao productDao;

   @Autowired
   public ProductController(ProductDao productDao) {
	  this.productDao = productDao;
   }
}
