package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//SpringApplication.run(BackendApplication.class, args);
		
		
		
	}

}
