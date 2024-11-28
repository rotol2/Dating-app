package com.gn.controller;

import java.util.List;

import com.gn.model.dao.UserDAO;
import com.gn.model.vo.User;
import com.gn.model.vo.UserProfile;
import com.gn.model.vo.UserWithProfile;

public class UserController {
	private UserDAO userDAO;
	
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void registerUser(User user, UserProfile profile) {
		userDAO.createUser(user, profile);
	}
	
	public List<UserWithProfile> getAllUsersWithProfiles() {
		return userDAO.selectAllUsersWithProfiles();
	}
	
	public UserWithProfile getUsersWithProfileById(int userId) {
		return userDAO.selectUserWithProfile(userId);
	}
	
	public void updateUser(User user, UserProfile profile) {
		userDAO.updateUser(user, profile);
	}
	
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}
}
