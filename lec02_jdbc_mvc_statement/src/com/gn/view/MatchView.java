package com.gn.view;

import java.util.List;
import java.util.Scanner;

import com.gn.controller.MatchController;
import com.gn.model.vo.SecureAuth;
import com.gn.model.vo.UserWithProfile;

public class MatchView {
	private MatchController matchController;
	private SecureAuth userSession;
	private Scanner scanner;
	private static final int PAGE_SIZE = 2;

	public MatchView(MatchController matchController, SecureAuth userSession) {
		this.matchController = matchController;
		this.userSession = userSession;
		this.scanner = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("현재 로그인된 사용자: " + userSession.getUsername());
		while (true) {
			System.out.println("== 메인 메뉴 ==");
			System.out.println("1. 매칭할 유저 조회");
			System.out.println("X. 종료");
			System.out.print("메뉴 선택 : ");
			int input = scanner.nextInt();
			scanner.nextLine();

			switch (input) {
			case 1:
				viewMatchingUsers();
				break;
			case 5:
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}

	private void viewMatchingUsers() {
		int page = 0;
		while (true) {
			List<UserWithProfile> matchingUsers = matchController.getMatchingUsers(page, PAGE_SIZE);
			// [수정함]
			// 다음페이지를 눌렀을 때, matchingUsers가 비어 있으면 page 값을 증가/감소 시키지 않고 그대로 유지시킴
			// 비어 있어도 메뉴는 클릭가능하게 함
			// 근데 데이터가 처음부터 비어있어도 출력가능한지 확인해봐야함!(데이터 안비워봄 ㅠ)
			if (!matchingUsers.isEmpty()) {
				System.out.println("\n== 매칭할 유저 목록(페이지 " + (page + 1) + ") ==");
				for (UserWithProfile user : matchingUsers) {
					System.out.println("---------------------------------------------------------------------");
					System.out.println("ID: " + user.getUser().getUserId() + " | 이름: " + user.getUser().getUsername() + " | MBTI: " + user.getUserProfile().getMbti());
					System.out.println("키: " + user.getUserProfile().getHeight() + " | 성: " + user.getUserProfile().getGender() + " | 생년월일: " + user.getUserProfile().getBirth());
					System.out.println("---------------------------------------------------------------------");
				}
			} else {
				System.out.println("매칭할 유저 목록 없음");
			}

			System.out.println("\n1. 다음 페이지 | 2. 이전 페이지 | 3. 상세정보 조회 | 4. 종료");
			System.out.println("메뉴 선택: ");
			int input = scanner.nextInt();
			scanner.nextLine();

			if (input == 1) {
	            matchingUsers = matchController.getMatchingUsers(page + 1, PAGE_SIZE);
	            if (!matchingUsers.isEmpty()) {
					page++;
				} else {
					System.out.println("마지막 페이지 입니다.");
				}
			} else if (input == 2) {
				page = Math.max(0, page - 1);
			} else if (input == 3) {
				viewTargetUserDetails();
			} else if (input == 4) {
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}

	private void viewTargetUserDetails() {
		System.out.println("상세 정보를 확인할 유저의 ID: ");
		int userId = scanner.nextInt();
		scanner.nextLine();

		UserWithProfile userWithProfile = matchController.getUserDetailsById(userId);
		if (userWithProfile != null) {
			System.out.println("\n== 유저 상세 정보 ==");
			System.out.println("ID: " + userWithProfile.getUser().getUserId());
			System.out.println("이름: " + userWithProfile.getUser().getUsername());
			System.out.println("이메일: " + userWithProfile.getUser().getEmail());
			System.out.println("MBTI: " + userWithProfile.getUserProfile().getMbti());
			System.out.println("자기소개: " + userWithProfile.getUserProfile().getBio());

			while (true) {
				System.out.println("\n1. 메시지 보내기 | 2. 하트 보내기 | 3. 돌아가기");
				System.out.print("메뉴 선택: ");
				int input = scanner.nextInt();
				scanner.nextLine();

				if (input == 1) {
					// sendMesageToUser(userId);
				} else if(input == 2) {
					// sendHeartToUser(userId);
				} else if(input == 3) {
					viewMatchingUsers();
				} else {
					System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
				}
			}
		} else {
			System.out.println("해당 회원이 존재하지 않습니다.");
		}

	}
}
