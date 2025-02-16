package com.gn.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBHelper {
	private static final String URL = "jdbc:mysql://localhost:3306/jdbc_test";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	public static Connection connect() throws SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void disconnect(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	
//	public List<User> selectMember() {
//		String query = "SELECT member_no,\n"
//				+ "    member_id,\n"
//				+ "    member_pwd,\n"
//				+ "    member_name,\n"
//				+ "    member_email,\n"
//				+ "    member_phone,\n"
//				+ "    member_gender,\n"
//				+ "    reg_date,\n"
//				+ "    mod_date\n"
//				+ "FROM member;";
//		
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        List<User> list = null;
//        try {
//        	conn = connect();
//        	pstmt = conn.prepareStatement(query);
//        	rs = pstmt.executeQuery();
//        	
//        	list = new ArrayList<User>();
//        	while (rs.next()) {
//        		User m = new User(
//        					rs.getString("member_id"),
//        					rs.getString("member_pwd"),
//        					rs.getString("member_name"),
//        					rs.getString("member_email"),
//        					rs.getString("member_phone"),
//        					rs.getString("member_gender"), 
//        					rs.getTimestamp("reg_date").toLocalDateTime(),
//        					rs.getTimestamp("mod_date").toLocalDateTime()
//        				);
//        		list.add(m);
//        		System.out.println(m.toString());
//        	}
//        } catch (Exception e) {
//        	e.printStackTrace();
//        } finally {
//        	disconnect(conn, pstmt, rs);
//        }
//		return list;
//	}
//	
//	public boolean insertMember(User member) {
//		String query = "INSERT INTO member (member_id, member_pwd, member_name, member_email, member_phone, member_gender, reg_date, mod_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//	    
//        try {
//        	conn = connect();
//        	pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, member.getMemberId());
//            pstmt.setString(2, member.getMemberPwd());
//            pstmt.setString(3, member.getMemberName());
//            pstmt.setString(4, member.getMemberEmail());
//            pstmt.setString(5, member.getMemberPhone());
//            pstmt.setString(6, member.getMemberGender());
//			pstmt.setTimestamp(7, Timestamp.valueOf(member.getRegDate())); 
//			pstmt.setTimestamp(8, Timestamp.valueOf(member.getModDate())); 
//            
//            int result = pstmt.executeUpdate();
//
//            if (result > 0) {
//    			System.out.println("데이터 입력 성공.");
//    			return true;
//    		} else {
//    			System.out.println("데이터 입력 실패.");
//    			return false;
//    		}
//        } catch (Exception e) {
//        	e.printStackTrace();
//        	return false;
//        } finally {
//        	disconnect(conn, pstmt, null);
//        }
//	}
//	
//	public boolean updateMember(User member) {
//		String query = "UPDATE member\n"
//				+ "SET\n"
//				+ "	member_pwd = ?,\n"
//				+ "	member_email = ?,\n"
//				+ "	member_phone = ?,\n"
//				+ "	mod_date = ?\n"
//				+ "WHERE member_no = ?;";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//	    
//        try {
//        	conn = connect();
//        	pstmt = conn.prepareStatement(query);
//            pstmt.setString(1, member.getMemberPwd());
//            pstmt.setString(2, member.getMemberEmail());
//            pstmt.setString(3, member.getMemberPhone());
//            pstmt.setTimestamp(4, Timestamp.valueOf(member.getModDate()));
//            pstmt.setInt(5, member.getMemberNo());
//
//            int result = pstmt.executeUpdate();
//
//            if (result > 0) {
//    			System.out.println("데이터 수정 성공.");
//    			return true;
//    		} else {
//    			System.out.println("데이터 수정 실패.");
//    			return false;
//    		}
//        } catch (Exception e) {
//        	e.printStackTrace();
//        	return false;
//        } finally {
//        	disconnect(conn, pstmt, null);
//        }
//	}
//	
//	public boolean deleteMember(int member_id) {
//		String query = "DELETE FROM member\n"
//				+ "WHERE member_no=?;";
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//	    
//        try {
//        	conn = connect();
//        	pstmt = conn.prepareStatement(query);
//            pstmt.setInt(1, member_id);
//   
//            int result = pstmt.executeUpdate();
//
//            if (result > 0) {
//    			System.out.println("데이터 삭제 성공.");
//    			return true;
//    		} else {
//    			System.out.println("데이터 삭제 실패.");
//    			return false;
//    		}
//        } catch (Exception e) {
//        	e.printStackTrace();
//        	return false;
//        } finally {
//        	disconnect(conn, pstmt, null);
//        }
//	}

//	// matchDAO의 findSearchingUsers메소드를 위해 추가함
//	public static void disconnect(Connection conn, Statement pstmt, ResultSet rs) {
//		try {
//			if (rs != null) rs.close();
//			if (pstmt != null) pstmt.close();
//			if (conn != null) conn.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
