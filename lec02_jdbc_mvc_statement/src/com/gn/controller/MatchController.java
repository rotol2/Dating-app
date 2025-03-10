package com.gn.controller;

import java.util.List;

import com.gn.model.dao.MatchDAO;
import com.gn.model.vo.Message;
import com.gn.model.vo.UserWithProfile;

public class MatchController {
	private MatchDAO matchDAO;
	
	public MatchController(MatchDAO matchDAO) {
		this.matchDAO = matchDAO;
	}

	public List<UserWithProfile> getSearchingUsers(StringBuilder whereQuery, int pageSize, int page) {
		return matchDAO.findSearchingUsers(whereQuery, pageSize , page);
	}
	
	public UserWithProfile getUserDetailsById(int userId) {
		return matchDAO.findUserById(userId);
	}
	
	public boolean sendMessage(int senderId, int receiverId, String message) {
		return matchDAO.insertMessage(senderId, receiverId, message);
	}
	
	public boolean sendFavorite(int senderId, int receiverId) {
		return matchDAO.insertFavorite(senderId, receiverId);
	}
	
	public boolean sendRating(int senderId, int receiverId, int rating) {
		return matchDAO.insertRating(senderId, receiverId, rating);
	}
	
	public List<Message> getMessagesForUser(int userId) {
		return matchDAO.getMessagesForUser(userId);
	}
	
}
