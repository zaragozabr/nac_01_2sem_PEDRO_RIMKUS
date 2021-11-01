package com.fiap.servicocliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.servicocliente.model.Atividade;
import com.fiap.servicocliente.model.Cliente;

//Rest API 
@SpringBootApplication
@RestController
public class ServicoClienteApplication {
	
	@GetMapping("/")
	public String get() {
		
		return "Bem vindo a rest API. "; 
	}

	public static void main(String[] args) {
		SpringApplication.run(ServicoClienteApplication.class, args);
	}

}
