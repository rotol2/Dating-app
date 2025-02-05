package com.gn.view;

import java.util.Scanner;

import com.gn.controller.MatchController;
import com.gn.controller.SecureAuthController;
import com.gn.controller.UserController;
import com.gn.model.dao.MatchDAO;
import com.gn.model.vo.SecureAuth;

public class LoginView {
	private SecureAuthController secureAuthController;
	private UserController userController;
	private Scanner scanner;
	
	public LoginView(SecureAuthController secureAuthController) {
	    this.secureAuthController = secureAuthController;
	    this.scanner = new Scanner(System.in);
	}
	
	public void showMenu() {
		while(true) {
			System.out.println("== 로그인 화면 ==");
			System.out.println("1. 로그인");
			System.out.println("2. 종료");
			System.out.print("메뉴 선택 : ");
			int input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input){
				case 1:
					loginUser();
					break;
				case 2:
					System.out.println("프로그램을 종료합니다.");
	                scanner.close();
	                System.exit(0);
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}
	private void loginUser() {
//		System.out.println("== 로그인 ==");
//		System.out.print("이메일: ");
//		String email = scanner.nextLine();
//		System.out.print("비밀번호: ");
//		String password = scanner.nextLine();
//
//		SecureAuth userSession = secureAuthController.loginProcess(email, password);
		SecureAuth userSession = secureAuthController.loginProcess("t1@gmail.com","");
		if (userSession != null) {
			System.out.println(userSession.getUsername() + "님, 환영합니다.");
			MatchController matchController = new MatchController(new MatchDAO());
	        new MainUserMenu(userSession).showMenu();  // 회원 관리 메뉴로 이동
		} else {
	        System.out.println("로그인 실패. 다시 시도하세요.");
	    }
	}

}
