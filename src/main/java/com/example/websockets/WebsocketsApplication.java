package com.example.websockets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Standard @SpringBootApplication annotated class, with a couple of logs to
 * show it is running.
 * 
 * @author admoreno
 *
 */

@SpringBootApplication
public class WebsocketsApplication {

	private static Logger log = LoggerFactory.getLogger(WebsocketsApplication.class);

	public static void main(String[] args) {
		log.info("WebSockets Application. Starting...");
		SpringApplication.run(WebsocketsApplication.class, args);
		log.info("WebSockets Application. Running...");
	}

}
