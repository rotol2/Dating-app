package com.gn.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.gn.common.validateHelper;
import com.gn.controller.MatchController;
import com.gn.controller.UserController;
import com.gn.model.vo.Message;
import com.gn.model.vo.SecureAuth;
import com.gn.model.vo.User;
import com.gn.model.vo.UserProfile;
import com.gn.model.vo.UserWithProfile;

public class MatchView {
	private UserController userController;
	private MatchController matchController;
	private SecureAuth userSession;
	private Scanner scanner;
	private static final int PAGE_SIZE = 2;

	public MatchView(UserController userController, MatchController matchController, SecureAuth userSession) {
		this.userController = userController;
		this.matchController = matchController;
		this.userSession = userSession;
		this.scanner = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("현재 로그인된 사용자: " + userSession.getUsername());
		while (true) {
			System.out.println("== 메인 메뉴 ==");
			System.out.println("1. 매칭할 유저 조회");
			System.out.println("2. 받은 메시지 확인");
			// 찜확인,평점 확인 기능도 추가해야 하나??
			System.out.println("3. 유저 검색");
			System.out.println("X. 종료");
			System.out.print("메뉴 선택 : ");
			int input = scanner.nextInt();
			scanner.nextLine();

			switch (input) {
			case 1:
				viewMatchingUsers();
				break;
			case 2:
				viewMessages();
				break;
			case 3:
				searchUsers();
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
					System.out.println("ID: " + user.getUser().getUserId() + " | 이름: " + user.getUser().getUsername()
							+ " | MBTI: " + user.getUserProfile().getMbti());
					System.out.println("키: " + user.getUserProfile().getHeight() + " | 성: "
							+ user.getUserProfile().getGender() + " | 생년월일: " + user.getUserProfile().getBirth());
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
				System.out.println("\n1. 메시지 보내기 | 2. 하트 보내기 | 3. 평점 입력 | 4. 돌아가기");
				System.out.print("메뉴 선택: ");
				int input = scanner.nextInt();
				scanner.nextLine();

				if (input == 1) {
					sendMessageToUser(userId);
				} else if (input == 2) {
					sendFavoriteToUser(userId);
				} else if (input == 3) {
					sendRatingToUser(userId);
					break;
				} else if (input == 4) {
					break;
				} else {
					System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
				}
			}
		} else {
			System.out.println("해당 회원이 존재하지 않습니다.");
		}

	}

	private void sendMessageToUser(int userId) {
		System.out.print("메세지 내용 : ");
		String message = scanner.nextLine();
		boolean result = matchController.sendMessage(userSession.getUserId(), userId, message);
		System.out.println(result ? "메세지가 성공적으로 전송 되었습니다." : "메세지 전송에 실패했습니다.");
	}

	private void sendFavoriteToUser(int userId) {
		boolean result = matchController.sendFavorite(userSession.getUserId(), userId);
		System.out.println(result ? "찜하기 성공" : "찜하기 실패");
	}

	private void sendRatingToUser(int userId) {
		int rating;
		while (true) {
			try {
				System.out.print("평점 입력(최저:1 ~ 최고:5) : ");
				rating = scanner.nextInt();
				if (1 <= rating && rating <= 5) {
					break;
				} else {
					System.out.println("잘못된 입력입니다. 1부터 5사이의 값을 입력해주세요.");
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
				scanner.nextLine();
			}
		}
		boolean result = matchController.sendRating(userSession.getUserId(), userId, rating);
		System.out.println(result ? "평점이 성공적으로 등록되었습니다." : "평점 등록에 실패했습니다.");
	}

	private void viewMessages() {
		try {
			List<Message> messages = matchController.getMessagesForUser(userSession.getUserId());
			if (messages.isEmpty()) {
				System.out.println("받은 메시지가 없습니다.");
				return;
			}

			System.out.println("\n== 받은 메시지 목록 ==");
			for (Message message : messages) {
				System.out.println("보낸 사람 ID: " + message.getSenderId() + " | 메시지: " + message.getMessage()
						+ " | 보낸 시간: " + message.getSentAt());
			}

			System.out.print("\n답장할 메시지의 보낸 사람 ID를 입력하세요: ");
			int senderId = scanner.nextInt();
			scanner.nextLine();

			System.out.print("답장 내용: ");
			String replyMessage = scanner.nextLine();

			boolean result = matchController.sendMessage(userSession.getUserId(), senderId, replyMessage);
			System.out.println(result ? "답장이 성공적으로 전송되었습니다." : "답장 전송에 실패했습니다.");
		} catch (NullPointerException e) {
			System.out.println("오류: 매치 컨트롤러가 초기화되지 않았습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// (숙제 2번)
	// 조건에 따른 유저 검색이 가능하다면 매칭할 유저 조회는 관리자만 가능해야 할듯 (userview의 전체회원목록보기에 해당)
	// -> 해당 클래스의 매칭할 유저조회를 해당 메소드에 메소드명(or 코드) 끌고와서 써보기

	private void searchUsers() {
		List<String> conditions = new ArrayList<String>();
		StringBuilder whereQuery = new StringBuilder();
		validateHelper validateHelper = new validateHelper(); 
		
		while (true) {		
			try {
				System.out.print("검색 항목 선택( 1.나이 2.키 3.성별 4.흥미 5.mbti 6.검색 : ");
				String inputStr = scanner.nextLine().trim();
				int input;
				
				try {
					input = Integer.parseInt(inputStr);
				} catch (NumberFormatException e) {
					System.out.println("숫자만 입력해주세요.");
					continue;
				}
				
				if (input < 1 || input > 6) {
					System.out.println("1부터 6 사이의 숫자를 입력해주세요.");
					continue;
				}

				if(input == 1) {
					while (true) {
						System.out.print("생년(년도 4자리) 입력 : ");
						String year = scanner.nextLine().trim();
						
						if (validateHelper.isValidYear(year)) {
							conditions.add("YEAR(birth) = " + year);
							break;
						} else {
							System.out.println("올바른 년도 형식(예: 1990)으로 입력해주세요.");
						}
					}
				} else if(input == 2) {
					while (true) {
							System.out.print("키 입력 : ");
							String beforeHeight = scanner.nextLine().trim();
							
							if(validateHelper.isValidHeight(beforeHeight)) {
								int height = Integer.parseInt(beforeHeight);							
								while (true) {
									System.out.print("[1]이상/[2]이하 : ");
									String choiceStr = scanner.nextLine().trim();								
									try {
										int nextChoice = Integer.parseInt(choiceStr);
										if (nextChoice == 1) {
											conditions.add("height >= " + height);
											break;
										} else if (nextChoice == 2) {
											conditions.add("height <= " + height);
											break;
										} else {
											System.out.println("1 또는 2만 입력해주세요.");
										}
									} catch (NumberFormatException e) {
										System.out.println("숫자만 입력해주세요.");
									}
								}
								break;
							} else {
								 System.out.println("올바른 키 형식(예: 175)으로 입력해주세요.");
							}
					}
				} else if(input == 3) {
					// 수정해야함
					int userId = userSession.getUserId();
					UserWithProfile userWithProfile = userController.getUsersWithProfileById(userId);
					UserProfile userProfile = userWithProfile.getUserProfile();
					String userGender = userProfile.getGender();	
					
					if(userGender.equals("male")) {
						conditions.add("gender = 'female'");
					}else if(userGender.equals("female")) {
						conditions.add("gender = 'male'");
					}
					
				} else if(input == 4) {
					// 수정해야함
					System.out.print("흥미 검색 : ");
					String interest = scanner.nextLine();
					
					conditions.add("interests = '" + interest + "'");
				} else if(input == 5) {
					while(true) {
						System.out.print("mbti 검색 : ");
						String mbti = scanner.nextLine();
						
						if(validateHelper.isValidMbti(mbti)) {
							conditions.add("mbti = '" + mbti + "'");
							break;
						} else {
							System.out.println("올바른 MBTI 형식(예: ENTJ)으로 입력해주세요.");
						}
					}
				}
				
				else if(input == 6) {					
					if (!conditions.isEmpty()) {
						whereQuery.append("WHERE ");
						whereQuery.append(String.join(" AND ", conditions));
						
						List<UserWithProfile> searchingUsers = matchController.getSearchingUsers(whereQuery);
						if (searchingUsers.isEmpty()) {
							System.out.println("검색 결과가 없습니다.");
						} else {
							System.out.println("-----------------------");
							for (UserWithProfile u : searchingUsers) {
								User user = u.getUser();
								UserProfile profile = u.getUserProfile();
								System.out.println("User ID : " + user.getUserId());
								System.out.println("User Name : " + user.getUsername());
								System.out.println("생년 : " + profile.getBirth().getYear());
								System.out.println("키 : " + profile.getHeight());
								System.out.println("성별 : " + profile.getGender());
								System.out.println("사진 : " + profile.getProfilePicture());
								System.out.println("흥미 : " + profile.getInterests());
								System.out.println("MBTI : " + profile.getMbti());
								System.out.println("자기소개 : " + profile.getBio());
								System.out.println("-----------------------");
							}
						}
						break;
					}
				}
			} catch (Exception e) {
	            System.out.println("처리 중 오류가 발생했습니다. 다시 시도해주세요.");
	            e.printStackTrace();
	            scanner.nextLine(); // 입력 버퍼 비우기
	        }
		}
	}
	
	
	
	
}
