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
		   int userChoice = displayMainMenu();

		   switch(userChoice) {
			  case 1 -> processListProducts(productDao);
			  case 2 -> processAddNewProduct(productDao);
			  case 0 -> ifContinue = false;
			  default -> System.err.println("ERROR! Please enter option on the list!");
		   }
		}

	}

   private static int displayMainMenu() {
	  System.out.println("--------MAIN MENU--------");
	  System.out.println("\n---OPTIONS---");
	  System.out.println("""
					1 - List All Products
					2 - Add New Product
					0 - Exit
					""");
	  System.out.println("\nEnter your option: ");

	  return Integer.parseInt(myScanner.nextLine());
   }

	static void processListProducts(ProductDao productDao) {
	   for (Product p : productDao.getAll()) {
		  p.print();
	   }
	}

	static void processAddNewProduct(ProductDao productDao) {
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
