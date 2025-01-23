package com.gn.model.vo;

import java.time.LocalDateTime;

public class Marks {
	
	private int markId;
	private int senderId;
	private int receiverId;
	private int mark;
	private LocalDateTime sendAt;
	
	public Marks(int markId, int senderId, int receiverId, int mark, LocalDateTime sendAt) {
		super();
		this.markId = markId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.mark = mark;
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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public LocalDateTime getSendAt() {
		return sendAt;
	}

	public void setSendAt(LocalDateTime sendAt) {
		this.sendAt = sendAt;
	}
	

	
}
