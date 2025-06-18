package com.example.NorthwindTradersAPI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

   @GetMapping(path = "/")
   public String homepage(@RequestParam(defaultValue = "World")
						  String country) {
	  return "Hello, " + country + "!";
   }

}
