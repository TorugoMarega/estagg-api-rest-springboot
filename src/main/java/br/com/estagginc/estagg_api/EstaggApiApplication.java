package br.com.estagginc.estagg_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EstaggApiApplication {
	@GetMapping
	public ResponseEntity<String> testConnection(){
		return new ResponseEntity<>("Conexão Estabelecida!", HttpStatus.OK);
	}

	public static void main(String[] args) {
		SpringApplication.run(EstaggApiApplication.class, args);
		System.out.println("API ONLINE!!!");
	}

}
