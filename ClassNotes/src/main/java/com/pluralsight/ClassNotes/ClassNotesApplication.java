package com.pluralsight.ClassNotes;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ClassNotesApplication {

	public static void main(String[] args) {
	   ConfigurableApplicationContext context = SpringApplication.run(ClassNotesApplication.class, args);

	}

}
