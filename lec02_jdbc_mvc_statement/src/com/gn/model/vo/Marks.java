package com.gn.model.vo;

import java.time.LocalDateTime;

public class Marks {
	
	private int markId;
	private int senderId;
	private int receiverId;
	private int count;
	private LocalDateTime sendAt;
	
	public Marks(int markId, int senderId, int receiverId, int count, LocalDateTime sendAt) {
		super();
		this.markId = markId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.count = count;
		this.sendAt = sendAt;
	}

	public int getMarkId() {
		return markId;
	}

	public void setMarkId(int markId) {
		this.markId = markId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public LocalDateTime getSendAt() {
		return sendAt;
	}

	public void setSendAt(LocalDateTime sendAt) {
		this.sendAt = sendAt;
	}
	
}
