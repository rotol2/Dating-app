package com.gn.view;

import java.util.Scanner;

import com.gn.controller.MatchController;
import com.gn.controller.UserController;
import com.gn.model.dao.MatchDAO;
import com.gn.model.dao.UserDAO;
import com.gn.model.vo.SecureAuth;

public class MainUserMenu {
	private UserController userController;
	private MatchController matchController;
	private SecureAuth userSession;
	private Scanner scanner;
	
	public MainUserMenu(SecureAuth userSession) {
		this.userSession = userSession;
		this.scanner = new Scanner(System.in);
	}
	
	public void showMenu() {
		System.out.println("현재 로그인된 사용자: " + userSession.getUsername());
		while(true) {
			System.out.println("== 메인 메뉴 ==");
			System.out.println("1. 회원 관리");
			System.out.println("2. 회원 매칭");
			System.out.println("3. 로그아웃");
			System.out.print("메뉴 선택 : ");
			int input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input){
				case 1:
					UserDAO userDAO = new UserDAO();
					// 왜 userDAO는 메소드 밖에서 변수선언 안하고, userContoller만 한건지??
					this.userController = new UserController(userDAO);
					new UserView(userController, userSession).showMenu();
					break;
				case 2:
					MatchDAO matchDAO = new MatchDAO();
					this.matchController = new MatchController(matchDAO);
					new MatchView(matchController, userSession).showMenu();
					return;
				case 3:
					logout();
					return;
				default:
					System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}
	
	private void logout() {
		this.userSession = null;
		System.out.println("로그아웃되었습니다.");
	}
}
