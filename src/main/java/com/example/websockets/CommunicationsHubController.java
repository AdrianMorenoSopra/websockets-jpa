package com.example.websockets;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.example.websockets.models.Message;
import com.example.websockets.services.MessageService;

/**
 * Chat controller, using STOMP WebSockets.
 * 
 * @author admoreno
 *
 */

@Controller
public class CommunicationsHubController {
	
	private static Message welcomeMessage = 
			new Message("Welcome to WebSocketsJPA chat! (Not the best name in the world, I know)");
	
	static {
		welcomeMessage.setUser("System");
	}

	@Autowired
	MessageService service;

	/**
	 * Main topic of the chat, to broadcast messages between all users, after a
	 * simulated delay of 1 sec.
	 * 
	 * @param message
	 *            The message that the user has sent by the chat.
	 * @return The message, with the populated id, after been saved to the DB.
	 * @throws Exception
	 *             Any exception will be throw and result in a 500 error
	 */
	@MessageMapping("/send")
	@SendTo("/topic/verbose")
	public Message send(Message message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return service.save(message);
	}

	/**
	 * Method used to retrieve message history of the db and send it to a user when
	 * it connects. The history is sent only to the subscribing user.
	 * 
	 * @return A list of all the {@code Message} that are stored on the DB.
	 * @throws Exception
	 *             Any exception will be throw and result in a 500 error
	 */
	@SubscribeMapping("/verbose")
	public List<Message> sendSysReply() throws Exception {
		List<Message> result = service.findAll();
		welcomeMessage.setDate(LocalDateTime.now());
		result.add(welcomeMessage);
		return result;
	}

}