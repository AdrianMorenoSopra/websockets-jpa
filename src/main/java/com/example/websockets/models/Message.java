package com.example.websockets.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Message implements Serializable{
	
	private static final long serialVersionUID = 3768018051471469579L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "Seq")
	@SequenceGenerator(sequenceName = "SEQ", name="Seq", allocationSize=1, initialValue=10)
	private long id;
	
	private String content;
	private String user;
	private LocalDateTime date = LocalDateTime.now();
	
	
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
