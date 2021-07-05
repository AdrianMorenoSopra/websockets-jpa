package com.example.websockets.models;

import java.util.Date;

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
	private String user;
	private Date date = new Date();
	
	
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
