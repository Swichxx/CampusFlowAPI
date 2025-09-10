package com.campusFlow.CampusFlow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CampusFlowApplication {

	public static void main(String[] args) {

		// Carrega o .env da raiz do projeto
	//	Dotenv dotenv = Dotenv.load();

		// Pega a variável ENDPOINT_KEY
	//	String endpointKey = dotenv.get("ENDPOINT_KEY");
		//System.out.println("Chave do endpoint: " + endpointKey);
		
		SpringApplication.run(CampusFlowApplication.class, args);
	}

}
