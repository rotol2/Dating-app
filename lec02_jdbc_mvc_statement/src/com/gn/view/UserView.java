package com.gn.view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.gn.common.GenericHelper;
import com.gn.common.GenericHelper.InputType;
import com.gn.controller.UserController;
import com.gn.model.vo.SecureAuth;
import com.gn.model.vo.User;
import com.gn.model.vo.UserProfile;
import com.gn.model.vo.UserWithProfile;

public class UserView {
	private UserController userController;
	private SecureAuth userSession;
	private Scanner scanner;

	public UserView(UserController userController, SecureAuth userSession) {
		this.userSession = userSession;
		this.userController = userController;
		this.scanner = new Scanner(System.in);
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
				scanner.close();
//				System.out.println("프로그램을 종료합니다.");
//				System.exit(0);
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}

	private void registerUser() {
		GenericHelper inputHelper = new GenericHelper();
		System.out.println("=== 회원 등록 ===");

	    String email = inputHelper.getInput("이메일: ", InputType.STRING, String.class);
	    String password = inputHelper.getInput("비밀번호: ", InputType.STRING, String.class);
	    String username = inputHelper.getInput("이름: ", InputType.STRING, String.class);
	    String state = "active";
	    LocalDate birth = inputHelper.getInput("생년월일 (YYYY-MM-DD): ", InputType.LOCAL_DATE, LocalDate.class);
	    int height = inputHelper.getInput("키: ", InputType.INTEGER, Integer.class);
	    String gender = inputHelper.getInput("성별 (male/female): ", InputType.STRING, String.class);
	    String phoneNumber = inputHelper.getInput("전화번호 (000-0000-0000): ", InputType.STRING, String.class);
	    String address = inputHelper.getInput("주소: ", InputType.STRING, String.class);
	    String profilePicture = inputHelper.getInput("프로필 사진 경로: ", InputType.STRING, String.class);
	    String interests = inputHelper.getInput("관심사: ", InputType.STRING, String.class);
	    String mbti = inputHelper.getInput("MBTI: ", InputType.STRING, String.class);
	    String bio = inputHelper.getInput("자기소개: ", InputType.STRING, String.class);

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
		if (userWithProfile != null) {
			User user = userWithProfile.getUser();
			UserProfile profile = userWithProfile.getUserProfile();

			System.out.println("=== 회원 정보 수정 ===");
			System.out.print("새 이메일 (현재: " + user.getEmail() + "): ");
			String newEmail = scanner.nextLine();
			System.out.print("새 비밀번호 (현재: " + user.getPassword() + "): ");
			String newPassword = scanner.nextLine();

			System.out.print("새 전화번호 (현재: " + profile.getPhoneNumber() + "): ");
			String newPhoneNumber = scanner.nextLine();
			System.out.print("새 주소 (현재: " + profile.getAddress() + "): ");
			String newAddress = scanner.nextLine();
			System.out.print("새 프로필 사진 경로 (현재: " + profile.getProfilePicture() + "): ");
			String newProfilePicture = scanner.nextLine();
			System.out.print("새 관심사 (현재: " + profile.getInterests() + "): ");
			String newInterests = scanner.nextLine();
			System.out.print("새 MBTI (현재: " + profile.getMbti() + "): ");
			String newMbti = scanner.nextLine();
			System.out.print("새 자기소개 (현재: " + profile.getBio() + "): ");
			String newBio = scanner.nextLine();

			user.setEmail(newEmail.trim().isEmpty() ? user.getEmail() : newEmail);
			user.setPassword(newPassword.trim().isEmpty() ? user.getPassword() : newPassword);
			profile.setPhoneNumber(newPhoneNumber.trim().isEmpty() ? profile.getPhoneNumber() : newPhoneNumber);
			profile.setAddress(newAddress.trim().isEmpty() ? profile.getAddress() : newAddress);
			profile.setProfilePicture(newProfilePicture.trim().isEmpty() ? profile.getProfilePicture() : newProfilePicture);
			profile.setInterests(newInterests.trim().isEmpty() ? profile.getInterests() : newInterests);
			profile.setMbti(newMbti.trim().isEmpty() ? profile.getMbti() : newMbti);
			profile.setBio(newBio.trim().isEmpty() ? profile.getBio() : newBio);

	        userController.updateUser(user, profile);
	        System.out.println("회원 정보가 업데이트되었습니다.");
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
