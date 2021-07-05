package com.example.websockets.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "Seq")
	@SequenceGenerator(sequenceName = "SEQ", name="Seq", allocationSize=1, initialValue=10)
	private long id;
	
	private String content;
	
	
	public Message() {}

	public Message(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

}
