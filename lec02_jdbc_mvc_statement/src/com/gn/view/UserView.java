package com.gn.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.gn.common.ValidateHelper;
import com.gn.controller.UserController;
import com.gn.enums.InputType;
import com.gn.model.vo.SecureAuth;
import com.gn.model.vo.User;
import com.gn.model.vo.UserProfile;
import com.gn.model.vo.UserWithProfile;

public class UserView {
	private UserController userController;
	private SecureAuth userSession;
	private Scanner scanner;
    private ValidateHelper validateHelper;

	public UserView(UserController userController, SecureAuth userSession) {
		this.userSession = userSession;
		this.userController = userController;
		this.scanner = new Scanner(System.in);
		this.validateHelper = new ValidateHelper();
	}

	public void showMenu() {
		System.out.println("현재 로그인된 사용자: " + userSession.getUsername());
		while (true) {
			System.out.println("== 회원 관리 메뉴 ==");
			System.out.println("1. 회원가입");
			System.out.println("2. 전체 회원 목록 보기");
			System.out.println("3. 개별 회원 정보 조회");
			System.out.println("4. 회원 정보 업데이트");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("6. 종료");
			System.out.print("메뉴 선택 : ");
			int input = scanner.nextInt();
			scanner.nextLine();

			switch (input) {
			case 1:
				registerUser();
				break;
			case 2:
				viewAllUsers();
				break;
			case 3:
				viewUserById();
				break;
			case 4:
				updateUser();
				break;
			case 5:
				deleteUser();
				break;
			case 6:
//				scanner.close();
//				System.out.println("프로그램을 종료합니다.");
//				System.exit(0);
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}

	private void registerUser() {
		System.out.println("=== 회원 등록 ===");

        String email = (String) validateHelper.getValidatedInput("이메일: ", InputType.EMAIL);
        String password = (String) validateHelper.getValidatedInput("비밀번호: ", InputType.PASSWORD);
	    String username = (String) validateHelper.getValidatedInput("사용자 이름: ", InputType.STRING);
	    String state = "active";
	    LocalDate birth = (LocalDate) validateHelper.getValidatedInput("생년월일 (YYYY-MM-DD): ", InputType.DATE);
	    int height = (Integer) validateHelper.getValidatedInput("키(cm): ", InputType.HEIGHT);
	    String gender = (String) validateHelper.getValidatedInput("성별(male/female/other): ", InputType.GENDER);
	    String phoneNumber = (String) validateHelper.getValidatedInput("전화번호 (000-0000-0000): ", InputType.PHONE);
	    String address = (String) validateHelper.getValidatedInput("주소: ", InputType.STRING);
	    String profilePicture = (String) validateHelper.getValidatedInput("프로필 사진 경로: ", InputType.STRING);
	    String interests = (String) validateHelper.getValidatedInput("관심사: ", InputType.STRING);
	    String mbti = (String) validateHelper.getValidatedInput("MBTI: ", InputType.MBTI);
	    String bio = (String) validateHelper.getValidatedInput("자기소개: ", InputType.STRING);
		LocalDateTime currentTime = LocalDateTime.now();

		// 생성자 매개변수 불일치 id매개변수 값에 0으로 넣으면 해결
		User user = new User(0, email, password, username, state, currentTime, currentTime);
		UserProfile profile = new UserProfile(0, 0, birth, height, gender, phoneNumber, address, profilePicture,
				interests, mbti, bio, currentTime, currentTime);

		userController.registerUser(user, profile);
		System.out.println("회원 등록이 완료되었습니다.");
	}

	private void viewAllUsers() {
		System.out.println("== 전체 회원 목록 ==");
		List<UserWithProfile> usersWithProfiles = userController.getAllUsersWithProfiles();
		System.out.println("-----------------------");
		for (UserWithProfile u : usersWithProfiles) {
			User user = u.getUser();
			UserProfile profile = u.getUserProfile();
			System.out.println("User ID : " + user.getUserId());
			System.out.println("이메일 : " + user.getEmail());
			System.out.println("이름 : " + user.getUsername());
			System.out.println("MBTI : " + profile.getMbti());
			System.out.println("자기소개 : " + profile.getBio());
			System.out.println("-----------------------");
		}
	}

	private void viewUserById() {
		System.out.print("조회할 회원 ID: ");
		int userId = scanner.nextInt();
		scanner.nextLine();
		UserWithProfile userWithProfile = userController.getUsersWithProfileById(userId);
		if (userWithProfile != null) {
			System.out.println("-----------------------");
			User user = userWithProfile.getUser();
			UserProfile profile = userWithProfile.getUserProfile();
			System.out.println("User ID: " + user.getUserId());
			System.out.println("이메일: " + user.getEmail());
			System.out.println("이름: " + user.getUsername());
			System.out.println("MBTI: " + profile.getMbti());
			System.out.println("자기소개: " + profile.getBio());
			System.out.println("-----------------------");
		} else {
			System.out.println("해당 ID의 회원이 존재하지 않습니다.");
		}
	}
	
	// 빈값 입력하면 기존 입력내용 유지하도록 함
	// 근데 여기도 올바른 입력이 아닐때, 다시 입력하도록 하는 코드를 추가해야할 듯 !
	// 회원가입 부분 수정 후 적용해봐야 함
	private void updateUser() {
		System.out.print("수정할 회원 ID: ");
		int userId = scanner.nextInt();
		scanner.nextLine();

		UserWithProfile userWithProfile = userController.getUsersWithProfileById(userId);
		User user = userWithProfile.getUser();
		UserProfile profile = userWithProfile.getUserProfile();
	
		if (userWithProfile != null) {
			System.out.println("=== 회원 정보 수정 ===");
	        while (true) {
	            System.out.println("변경 항목 선택( 1.이메일 2.비밀번호 3.전화번호 4.주소 5.프로필 사진 6.관심사 7.MBTI 8.자기소개 9.변경)");
	            int choice = (Integer) validateHelper.getValidatedInput("선택: ", InputType.INTEGER);

	            switch (choice) {
	                case 1:
	                    user.setEmail((String) validateHelper.getValidatedInput("새 이메일: ", InputType.EMAIL));
	                    break;
	                case 2:	
	                    user.setPassword((String) validateHelper.getValidatedInput("새 비밀번호: ", InputType.PASSWORD));
	                    break;
	                case 3:
	                	profile.setPhoneNumber((String) validateHelper.getValidatedInput("새 전화번호 (예: 000-0000-0000): ", InputType.PHONE));
	                	break;
	                case 4:
	                    profile.setAddress((String) validateHelper.getValidatedInput("새 주소: ", InputType.STRING));
	                    break;      
	                case 5:
	                    profile.setProfilePicture((String) validateHelper.getValidatedInput("새 프로필 사진 경로: ", InputType.STRING));
	                    break;
	                case 6:
	                    profile.setInterests((String) validateHelper.getValidatedInput("새 관심사: ", InputType.STRING));
	                    break;
	                case 7:
	                    profile.setMbti((String) validateHelper.getValidatedInput("새 MBTI: ", InputType.MBTI));
	                    break;
	                case 8:
	                	 profile.setBio((String) validateHelper.getValidatedInput("새 자기소개: ", InputType.STRING));
		                 break;
	                case 9:
	                    userController.updateUser(user, profile);
	                    System.out.println("회원 정보가 성공적으로 수정되었습니다!");
	                    return;
	                default:
	                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
	            }
	        }
	    } else {
	        System.out.println("해당 ID의 회원이 존재하지 않습니다.");
		}
	}
	
//	private String reGetInput() {
//		String input = null;
//		while (true) {
//			input = scanner.nextLine();
//			if (input.trim().isEmpty()) {
//				System.out.println("필수 입력 사항입니다.");
//			} else {
//				break;
//			}
//		}
//		return input;
//	}

	private void deleteUser() {
		System.out.print("삭제할 회원 ID: ");
		int userId = scanner.nextInt();
		scanner.nextLine();

		UserWithProfile userWithProfile = userController.getUsersWithProfileById(userId);
		if (userWithProfile != null) {
			userController.deleteUser(userId);
		} else {
			System.out.println("해당 ID의 회원이 존재하지 않습니다.");
		}
	}

}
