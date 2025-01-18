package com.gn.model.vo;

import java.time.LocalDateTime;

public class Favorite {

	private int favoriteId;
	private int senderId;
	private int receiverId;
	private LocalDateTime sendAt;
	
	public Favorite(int favoriteId, int senderId, int receiverId, LocalDateTime sendAt) {
		this.favoriteId = favoriteId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.sendAt = sendAt;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
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

	public LocalDateTime getSendAt() {
		return sendAt;
	}

	public void setSendAt(LocalDateTime sendAt) {
		this.sendAt = sendAt;
	}
	
	
	
}
