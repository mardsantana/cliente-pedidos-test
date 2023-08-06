package br.com.clientepedidos.clientepedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ClientePedidosApplication {

	@GetMapping
	public String getHomeTeste(){
		return "Gerenciador de Pedidos - Home API";
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientePedidosApplication.class, args);
	}

}
