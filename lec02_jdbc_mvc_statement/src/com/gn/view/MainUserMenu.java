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
//	public MainUserMenu(UserController userController, MatchController matchController, SecureAuth userSession) {
//		this.userController = userController;
//		this.matchController = matchController;
		this.userSession = userSession;
		this.scanner = new Scanner(System.in);
	}
	
	public void showMenu() {
		System.out.println("현재 로그인된 사용자: " + userSession.getUsername());
		UserDAO userDAO = new UserDAO();
		while(true) {
			System.out.println("\n== 메인 메뉴 ==");
			System.out.println("1. 회원 관리");
			System.out.println("2. 회원 매칭");
			System.out.println("3. 심리테스트");
			System.out.println("4. 로그아웃");
			System.out.print("메뉴 선택 : ");
			int input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input){
				case 1:
					this.userController = new UserController(userDAO);
					new UserView(userController, userSession).showMenu();
					break;
				case 2:
					this.userController = new UserController(userDAO);
					MatchDAO matchDAO = new MatchDAO();
					this.matchController = new MatchController(matchDAO);
					new MatchView(userController, matchController, userSession).showMenu();
					break;
					// 새로생성
				case 3:
				    new MbtiTestView().startTest();
				    //여기에 usersession 매개변수로 추가해야하나?
				    break;

					//여기까지
				case 4:
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
