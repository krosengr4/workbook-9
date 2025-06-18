package org.pluralsight.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NorthwindTraderApp implements CommandLineRunner {

   ProductDao productDao;
   static Scanner myScanner = new Scanner(System.in);

   @Autowired
   public NorthwindTraderApp(ProductDao productDao) {
	  this.productDao = productDao;
   }

   @Override
   public void run(String... args) {
	  boolean ifContinue = true;

	  while(ifContinue) {
		 int userChoice = displayMainMenu();

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


}
