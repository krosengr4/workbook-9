package org.pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class Main {

   static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
	   ApplicationContext context = SpringApplication.run(Main.class, args);
	   ProductDao productDao = context.getBean(ProductDao.class);

		boolean ifContinue = true;

		while (ifContinue) {
		   System.out.println("---OPTIONS---");
		   System.out.println("1 - List Products\n2 - Add New Product\n0 - Exit");
		   int userChoice = Integer.parseInt(myScanner.nextLine());

		   switch(userChoice) {
			  case 1 -> processListProducts();
			  case 2 -> processAddNewProduct();
			  case 0 -> ifContinue = false;
			  default -> System.err.println("ERROR! Please enter option on the list!");
		   }
		}

	}

	static void processListProducts() {
	   ArrayList<Product> productsList = productDao.getAll();

	   if (productsList.isEmpty()) {
		  System.out.println("No products found...");
	   } else {
		  for (Product p : productsList) {
			 p.print();
			 System.out.println("---------------------------------------------");
		  }
	   }
	}

	static void processAddNewProduct() {
	   System.out.println("Enter the ID: ");
	   int productID = Integer.parseInt(myScanner.nextLine());
	   System.out.println("Enter the Name: ");
	   String productName = myScanner.nextLine();
	   System.out.println("Enter the Category: ");
	   String category = myScanner.nextLine();
	   System.out.println("Enter the price");
	   double productPrice = Double.parseDouble(myScanner.nextLine());

	   Product product = new Product(productID, productName, category, productPrice);

	   productDao.addProduct(product);
	}

}
