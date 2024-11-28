package com.gn.run;

import com.gn.controller.SecureAuthController;
import com.gn.model.dao.SecureAuthDAO;
import com.gn.view.LoginView;

public class Run {
	public static void main(String[] args) {
		SecureAuthDAO secureAuthDAO = new SecureAuthDAO();
		SecureAuthController secureAuthController = new SecureAuthController(secureAuthDAO);

		LoginView loginView = new LoginView(secureAuthController);

		try {
		    loginView.showMenu();
		} catch (Exception e) {
		    e.printStackTrace();
		}
//		
//		UserDAO userDAO = new UserDAO();
//		UserController userController = new UserController(userDAO);
//		UserView userView = new UserView(userController);
//		
//		try {
//			userView.showMenu();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
	}

	
	
	public void test() {
//		List<UserWithProfile> users = new ArrayList<>();
//		UserDAO userDAO = new UserDAO();
//		users = userDAO.selectAllUsersWithProfiles();
//		for (UserWithProfile u : users) {
//			System.out.println(u.toString());
//		}
//		UserWithProfile user = null;
//		user = userDAO.selectUserWithProfile(8);
//		System.out.println(user.toString());
//		
//		
//		String email = "testuser@example.com";
//        String password = "password123";
//        String username = "TestUser";
//        String state = "active";
//		User user = new User(0, email, password, username, state, LocalDateTime.now(), LocalDateTime.now());
//        // UserProfile 객체 생성
//		
//		LocalDate birth = LocalDate.of(1990, 1, 1); // 생년월일
//        int height = 180;
//        String gender = "male";
//        String phoneNumber = "010-1234-5678";
//        String address = "123 Test Street, Test City";
//        String profilePicture = "/images/testuser.jpg";
//        String interests = "Music, Traveling";
//        String mbti = "INTJ";
//        String bio = "Hello! I am a test user.";
//        
//        UserProfile profile = new UserProfile(0, 0, birth, height, gender, phoneNumber, address, profilePicture, interests, mbti, bio, LocalDateTime.now(), LocalDateTime.now());
//        
//        UserDAO userDAO = new UserDAO();
//        // User와 UserProfile을 함께 등록
//        userDAO.createUser(user, profile);
//
//        System.out.println("회원과 프로필이 성공적으로 등록되었습니다.");
	}
}
