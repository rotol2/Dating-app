package com.gn.controller;

import java.util.List;

import com.gn.model.dao.MatchDAO;
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
	
}
