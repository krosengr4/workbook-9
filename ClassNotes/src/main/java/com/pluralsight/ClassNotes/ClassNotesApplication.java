package com.pluralsight.ClassNotes;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClassNotesApplication {

	public static void main(String[] args) {
	   ApplicationContext context = SpringApplication.run(ClassNotesApplication.class, args);

	}

}
