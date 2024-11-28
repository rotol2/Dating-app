package com.gn.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gn.model.vo.User;
import com.gn.model.vo.UserProfile;
import com.gn.model.vo.UserWithProfile;

public class MatchDAO {
	
	public List<UserWithProfile> findMatchingUsers(int page, int pageSize) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserWithProfile> matchingUsers = new ArrayList<>();
		
		try {
			conn = DBHelper.connect();
			String query = "SELECT u.user_id, u.username, p.birth, p.height, p.gender, p.mbti " +
						   "FROM users u INNER JOIN user_profiles p ON u.user_id = p.user_id " +
					       "LIMIT ? OFFSET ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pageSize);
			pstmt.setInt(2, page * pageSize); // pageSize 끝난 다음 부분부터 시작
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				
				UserProfile profile = new UserProfile();
				profile.setBirth(rs.getDate("birth").toLocalDate());
				profile.setHeight(rs.getInt("height"));
				profile.setGender(rs.getString("gender"));
				profile.setMbti(rs.getString("mbti"));
				
				matchingUsers.add(new UserWithProfile(user, profile));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.disconnect(conn, pstmt, rs);
		}
		
		return matchingUsers;
	}
	
	public UserWithProfile findUserById(int userId) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    User user = null;
	    UserProfile profile = null;
	    UserWithProfile userWithProfile = null;

	    try {
	        conn = DBHelper.connect();

	        String query = "SELECT u.user_id, u.email, u.password, u.username, u.state, u.created_at AS user_created_at, u.updated_at AS user_updated_at, " +
	                       "p.profile_id, p.birth, p.height, p.gender, p.phone_number, p.address, p.profile_picture, p.interests, p.mbti, p.bio, p.created_at AS profile_created_at, p.updated_at AS profile_updated_at " +
	                       "FROM users u " +
	                       "INNER JOIN user_profiles p ON u.user_id = p.user_id " +
	                       "WHERE u.user_id = ?";

	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, userId);

	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            // User 정보 생성
	            user = new User(
	                    rs.getInt("user_id"),
	                    rs.getString("email"),
	                    rs.getString("password"),
	                    rs.getString("username"),
	                    rs.getString("state"),
	                    rs.getTimestamp("user_created_at").toLocalDateTime(),
	                    rs.getTimestamp("user_updated_at").toLocalDateTime()
	            );

	            profile = new UserProfile(
	                    rs.getInt("profile_id"),
	                    rs.getInt("user_id"),
	                    rs.getDate("birth").toLocalDate(),
	                    rs.getInt("height"),
	                    rs.getString("gender"),
	                    rs.getString("phone_number"),
	                    rs.getString("address"),
	                    rs.getString("profile_picture"),
	                    rs.getString("interests"),
	                    rs.getString("mbti"),
	                    rs.getString("bio"),
	                    rs.getTimestamp("profile_created_at").toLocalDateTime(),
	                    rs.getTimestamp("profile_updated_at").toLocalDateTime()
	            );

	            userWithProfile = new UserWithProfile(user, profile);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBHelper.disconnect(conn, pstmt, rs);
	    }

	    return userWithProfile;
	}
	
}
