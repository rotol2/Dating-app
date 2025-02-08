package com.gn.model.vo;

import java.time.LocalDateTime;

public class Rating {
	
	private int ratingId;
	private int senderId;
	private int receiverId;
	private int rating;
	private LocalDateTime sendAt;
	
	public Rating(int ratingId, int senderId, int receiverId, int rating, LocalDateTime sendAt) {
		super();
		this.ratingId = ratingId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.rating = rating;
		this.sendAt = sendAt;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDateTime getSendAt() {
		return sendAt;
	}

	public void setSendAt(LocalDateTime sendAt) {
		this.sendAt = sendAt;
	}
	
	

}
