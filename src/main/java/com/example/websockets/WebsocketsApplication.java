package com.example.websockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketsApplication {

	public static void main(String[] args) {
		System.out.println("WebSockets Application. Starting...");
		SpringApplication.run(WebsocketsApplication.class, args);
		System.out.println("WebSockets Application. Running...");
	}

}
