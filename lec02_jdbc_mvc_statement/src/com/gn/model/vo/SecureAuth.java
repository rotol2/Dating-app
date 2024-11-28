package com.gn.model.vo;

public class SecureAuth {
    private int userId;
    private String email;
    private String username;
    
    public SecureAuth() {}
    
    public SecureAuth(int userId, String email, String username) {
    	this.userId = userId;
    	this.email = email;
    	this.username = username;
    }

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void getUsername(String username) {
		this.username = username;
	}
}
