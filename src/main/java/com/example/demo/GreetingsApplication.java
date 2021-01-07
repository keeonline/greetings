package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class GreetingsApplication {

	private Map<Integer,String> greetings;

	public GreetingsApplication(){
		greetings = new HashMap<>();
	}

	public static void main(String[] args) {
		SpringApplication.run(GreetingsApplication.class, args);
	}

//	@RequestMapping("/")
//	public String index() {
//		return "Hello World!";
//	}

	@PostMapping("/greetings")
	public String add(@RequestBody String greeting) {
		Integer key = greetings.size()+1;
		greetings.put(key,greeting);
		System.out.println("********************");
		System.out.println("key = value");
		greetings.entrySet().forEach( entry -> {
			System.out.println( entry.getKey() + "   = " + entry.getValue() );
		});
		return key.toString();
	}

	// Retrieve all greetings that have been added to the web service

	@GetMapping("/greetings")
	public String getAll() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Integer, String> entry : greetings.entrySet()) {
			sb.append(entry.getKey() + ":" + entry.getValue());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

	// Retrieve a particular greeting from the web service, by ID

	@GetMapping("/greetings/{id}")
	public String getById(@PathVariable Integer id) {
		return greetings.get(id);
	}
}
