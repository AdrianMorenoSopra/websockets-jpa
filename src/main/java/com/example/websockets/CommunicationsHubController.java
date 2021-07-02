package com.example.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.websockets.models.InboundMessage;
import com.example.websockets.models.OutboundMessage;

@Controller
public class CommunicationsHubController {
    @MessageMapping("/send")
    @SendTo("/topic/verbose")
    public OutboundMessage send(InboundMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new OutboundMessage(message.getContent());
    }
}