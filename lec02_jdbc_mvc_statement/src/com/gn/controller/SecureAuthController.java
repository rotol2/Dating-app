package com.gn.controller;

import com.gn.model.dao.SecureAuthDAO;
import com.gn.model.vo.SecureAuth;

public class SecureAuthController {
	private SecureAuthDAO authDAO;

	public SecureAuthController(SecureAuthDAO authDAO) {
		this.authDAO = authDAO;
	}

	public SecureAuth loginProcess(String email, String password) {
		return authDAO.findUserByEmailAndPassword(email, password);
	}
}
