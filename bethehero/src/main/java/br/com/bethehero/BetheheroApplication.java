package br.com.bethehero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BetheheroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetheheroApplication.class, args);
	}
	
	@GetMapping("/oi")
	public String helloWorld(@RequestParam(name = "nome", defaultValue = "Khaleesi") String nome) {
		return "<h1>Olá, " + nome + "!</h1>";
	}

}
