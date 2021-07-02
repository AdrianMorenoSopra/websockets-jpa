package com.example.websockets.data;

import lombok.Data;

//@Data
public abstract class Message {
	
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
