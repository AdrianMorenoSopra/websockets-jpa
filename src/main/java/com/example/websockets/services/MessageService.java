package com.example.websockets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.websockets.models.Message;
import com.example.websockets.repositories.MessageRepository;

/**
 * Message service. Acts as a proxy between Controller and Repository, and masks
 * some of the methods, as {@code findAll}
 * 
 * @author admoreno
 */
@Service
public class MessageService {

	@Autowired
	private MessageRepository repository;

	/**
	 * Return all messages in the server, internally, we order them by date.
	 * 
	 * @return List of all {@code Message} in the DB, ordered by
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
