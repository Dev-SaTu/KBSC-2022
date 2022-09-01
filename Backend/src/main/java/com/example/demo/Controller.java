package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/api/hi")
	public String hi() {
		return "이거 어디까지 올라가는 거에요?";
	}
	
}
