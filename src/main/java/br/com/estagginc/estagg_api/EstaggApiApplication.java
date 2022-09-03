package br.com.estagginc.estagg_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("")
public class EstaggApiApplication {
	@GetMapping
	public String testConnection(){
		return "API ONLINE!";
	}

	public static void main(String[] args) {
		SpringApplication.run(EstaggApiApplication.class, args);
		System.out.println("API ONLINE!");
	}

}
