package com.gn.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.gn.model.vo.User;
import com.gn.model.vo.UserProfile;
import com.gn.model.vo.UserWithProfile;

public class UserDAO {
	public void createUser(User user, UserProfile profile) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
        	conn = DBHelper.connect();
        	conn.setAutoCommit(false);
        	
        	String query1 = "INSERT INTO users (email, password, username, state, created_at, updated_at) VALUES (?,?,?,?,?,?)";
        	
        	pstmt1 = conn.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
        	pstmt1.setString(1, user.getEmail());
        	pstmt1.setString(2, user.getPassword());
        	pstmt1.setString(3, user.getUsername());
        	pstmt1.setString(4, user.getState());
        	pstmt1.setTimestamp(5, Timestamp.valueOf(user.getCreatedAt()));
        	pstmt1.setTimestamp(6, Timestamp.valueOf(user.getUpdatedAt()));
    		
        	pstmt1.executeUpdate();
    		ResultSet keys = pstmt1.getGeneratedKeys();
    		if (keys.next()) {
    			int userId = keys.getInt(1);
    			profile.setUserId(userId);
    		}
    		
    		String query2 = "INSERT INTO user_profiles (user_id, birth, height, gender, phone_number, address, profile_picture, interests, mbti, bio, created_at, updated_at) "
  			      + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    		pstmt2 = conn.prepareStatement(query2);
    		pstmt2.setInt(1, profile.getUserId());
    		pstmt2.setDate(2, Date.valueOf(profile.getBirth()));
    		pstmt2.setInt(3, profile.getHeight());
    		pstmt2.setString(4, profile.getGender());
    		pstmt2.setString(5, profile.getPhoneNumber());
    		pstmt2.setString(6, profile.getAddress());
    		pstmt2.setString(7, profile.getProfilePicture());
    		pstmt2.setString(8, profile.getInterests());
    		pstmt2.setString(9, profile.getMbti());
    		pstmt2.setString(10, profile.getBio());
    		pstmt2.setTimestamp(11, Timestamp.valueOf(profile.getCreatedAt()));
    		pstmt2.setTimestamp(12, Timestamp.valueOf(profile.getUpdatedAt()));
    		
    		int result = pstmt2.executeUpdate();

            if (result > 0) {
    			System.out.println("회원 가입 완료.");
    		} else {
    			System.out.println("회원 가입 실패.");
    			conn.rollback();
    			return;
    		}
        	
        	conn.commit();
        } catch (Exception e) {
        	if (conn != null) {
        		try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        	}
        	e.printStackTrace();
        } finally {
        	DBHelper.disconnect(conn, pstmt1, null);
        	DBHelper.disconnect(null, pstmt2, null);
        }
	}
	
	public List<UserWithProfile> selectAllUsersWithProfiles() {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    List<UserWithProfile> usersWithProfiles = new ArrayList<>();

	    try {
	        conn = DBHelper.connect();

	        String query = "SELECT u.user_id, u.email, u.password, u.username, u.state, u.created_at AS user_created_at, u.updated_at AS user_updated_at, " +
	                       "p.profile_id, p.birth, p.height, p.gender, p.phone_number, p.address, p.profile_picture, p.interests, p.mbti, p.bio, p.created_at AS profile_created_at, p.updated_at AS profile_updated_at " +
	                       "FROM users u " +
	                       "INNER JOIN user_profiles p ON u.user_id = p.user_id";

	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            User user = new User(
	                    rs.getInt("user_id"),
	                    rs.getString("email"),
	                    rs.getString("password"),
	                    rs.getString("username"),
	                    rs.getString("state"),
	                    rs.getTimestamp("user_created_at").toLocalDateTime(),
	                    rs.getTimestamp("user_updated_at").toLocalDateTime()
	            );

	            UserProfile profile = new UserProfile(
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

	            UserWithProfile userWithProfile = new UserWithProfile(user, profile);

	            usersWithProfiles.add(userWithProfile);
	        }

	        System.out.println("모든 회원 정보가 성공적으로 조회되었습니다.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBHelper.disconnect(conn, pstmt, rs);
	    }

	    return usersWithProfiles;
	}
	
	public UserWithProfile selectUserWithProfile(int userId) {
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
	            System.out.println("회원정보가 성공적으로 조회되었습니다.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBHelper.disconnect(conn, pstmt, rs);
	    }

	    return userWithProfile;
	}

	public void updateUser(User user, UserProfile profile) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
        	conn = DBHelper.connect();
        	conn.setAutoCommit(false);
        	
        	String query1 = "UPDATE users\n"
        			+ "SET email = ?,password = ?,state = ?,updated_at = ?\n"
        			+ "WHERE user_id = ?";
        	
    		pstmt1 = conn.prepareStatement(query1);
    		pstmt1.setString(1, user.getEmail());
    		pstmt1.setString(2, user.getPassword());
    		pstmt1.setString(3, user.getState());
    		pstmt1.setTimestamp(4, Timestamp.valueOf(user.getUpdatedAt()));  
    		pstmt1.setInt(5, user.getUserId());
    		
    		int result1 = pstmt1.executeUpdate();
    		
        	String query2 = "UPDATE user_profiles\n"
        			+ "SET phone_number = ?,address = ?,profile_picture = ?,interests = ?,mbti = ?,bio = ?,updated_at = ?\n"
        			+ "WHERE user_id = ?";
        	
        	pstmt2 = conn.prepareStatement(query2);
    		pstmt2.setString(1, profile.getPhoneNumber());
    		pstmt2.setString(2, profile.getAddress());
    		pstmt2.setString(3, profile.getProfilePicture());
    		pstmt2.setString(4, profile.getInterests());
    		pstmt2.setString(5, profile.getMbti());
    		pstmt2.setString(6, profile.getBio());
    		pstmt2.setTimestamp(7, Timestamp.valueOf(user.getUpdatedAt()));
    		pstmt2.setInt(8, user.getUserId());
    		
    		int result2 = pstmt2.executeUpdate();

            if (result1 > 0 && result2 > 0) {
            	conn.commit();
            	System.out.println("회원 수정 완료.");
    		} else {
    			conn.rollback();
    			System.out.println("회원 수정 실패.");
    		}
        } catch (Exception e) {
        	if (conn != null) {
        		try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
        	}
        	e.printStackTrace();
        } finally {
        	DBHelper.disconnect(conn, pstmt1, null);
        	DBHelper.disconnect(null, pstmt2, null);
        }
	}
	
	public void deleteUser(int userId) {
		Connection conn = null;
		PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

	    try {
	        conn = DBHelper.connect();
	        conn.setAutoCommit(false);

	        String query1 = "DELETE FROM user_profiles WHERE user_id = ?";
	        pstmt1 = conn.prepareStatement(query1);
	        pstmt1.setInt(1, userId);

	        int result1 = pstmt1.executeUpdate();

	        String query2 = "DELETE FROM users WHERE user_id = ?";
	        pstmt2 = conn.prepareStatement(query2);
	        pstmt2.setInt(1, userId);

	        int result2 = pstmt2.executeUpdate();

	        if (result1 > 0 && result2 > 0) {
	            conn.commit();
	            System.out.println("회원정보가 삭제되었습니다.");
	        } else {
	            conn.rollback();
	            System.out.println("삭제 실패.");
	        }

	    } catch (SQLException e) {
	        if (conn != null) {
	            try {
	                conn.rollback();
	            } catch (SQLException rollbackEx) {
	                rollbackEx.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        DBHelper.disconnect(conn, pstmt1, null);
	        DBHelper.disconnect(null, pstmt2, null);
	    }
	}
}
