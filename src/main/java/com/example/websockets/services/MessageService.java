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
	
	public List<Message> getAll() {
		return repository.findAll();
	}

}
