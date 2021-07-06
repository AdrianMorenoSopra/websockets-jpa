package com.example.websockets;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Configuration class that implements {@code WebSocketMessageBrokerConfigurer}
 * to configure the MessageBroker.
 * 
 * @author admoreno
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	/**
	 * Method that configs the channels of the chat.
	 * 
	 * @param config
	 *            The object whose methods are called to configure the chat.
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic/", "/queue");
		config.setApplicationDestinationPrefixes("/app", "/topic");
		config.setUserDestinationPrefix("/user");
	}

	/**
	 * Method that sets the endpoint of the chat.
	 * 
	 * @param registry
	 *            The object whose methods are called to configure the chat.
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/thedfa-communicationshub").withSockJS();
	}

}
