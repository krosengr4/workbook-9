package org.pluralsight.demo;

import java.util.ArrayList;

public interface ProductDao  {

   void addProduct(Product product);
   ArrayList<Product> getAll();

}
