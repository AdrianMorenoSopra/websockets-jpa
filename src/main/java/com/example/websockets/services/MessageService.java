package com.example.websockets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websockets.models.Message;
import com.example.websockets.repositories.MessageRepository;


@Service
public class MessageService {
	
	@Autowired
	private MessageRepository repository;
	
	/*
	 * Return all messages in the server, internally, we order them by date.
	 */
	public List<Message> findAll() {
		return repository.findAllByOrderByDateAsc();
	}
	
	/*
	 * Saves a message of the chat to the server.
	 */
	public Message save(Message message) {
		return repository.save(message);
	}

}
