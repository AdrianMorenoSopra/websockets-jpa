package com.example.websockets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import com.example.websockets.models.Message;
import com.example.websockets.services.MessageService;

@Controller
public class CommunicationsHubController {

	@Autowired
	MessageService service;

	@MessageMapping("/send")
	@SendTo("/topic/verbose")
	public Message send(Message message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return service.save(message);
	}

	@SubscribeMapping("/verbose")
	@SendToUser("/queue/reply")
	public List<Message> sendSysReply() throws Exception {
		return service.findAll();
	}

}