package com.gn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gn.common.DBHelper;
import com.gn.model.vo.SecureAuth;

public class SecureAuthDAO {
	
	public SecureAuth findUserByEmailAndPassword(String email, String password) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    SecureAuth secureAuth = null;
	    
	    try {
	        conn = DBHelper.connect();
	        String query = "SELECT * FROM users WHERE email=? AND password=?";
	        pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, email);
	        pstmt.setString(2, password);
	        rs = pstmt.executeQuery();
	
	        if (rs.next()) {
	        	secureAuth = new SecureAuth(
	                    rs.getInt("user_id"),
	                    rs.getString("email"),
	                    rs.getString("username")
	            );
	            System.out.println("로그인 되었습니다.");
	        } else {
	        	System.out.println("아이디나 패스워드를 확인해주세요");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBHelper.disconnect(conn, pstmt, rs);
	    }
	    
	    return secureAuth;
	}
}
