package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
