package com.gn.model.vo;

import java.time.LocalDateTime;

public class Message {
	
	private int messageId;
	private int senderId;
	private int reveiverId;
	private String message;
	private LocalDateTime sentAt;
	
	public Message() {}
	
	public Message(int messageId, int senderId, int reveiverId, String message, LocalDateTime sentAt) {
		this.messageId = messageId;
		this.senderId = senderId;
		this.reveiverId = reveiverId;
		this.message = message;
		this.sentAt = sentAt;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReveiverId() {
		return reveiverId;
	}

	public void setReveiverId(int reveiverId) {
		this.reveiverId = reveiverId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getSentAt() {
		return sentAt;
	}

	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	
	
	
}
