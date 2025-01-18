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
	
	public List<UserWithProfile> getMatchingUsers(int page, int pageSize) {
		return matchDAO.findMatchingUsers(page,pageSize);
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
	
	public boolean sendMark(int senderId, int receiverId, int mark) {
		return matchDAO.insertMark(senderId, receiverId, mark);
	}
	
	public List<Message> getMessagesForUser(int userId) {
		return matchDAO.getMessagesForUser(userId);
	}
	
	public List<UserWithProfile> getSearchingUsers(String item, String terms) {
		return matchDAO.findSearchingUsers(item, terms);
	}
	
}
