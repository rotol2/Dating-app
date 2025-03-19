package com.gn.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.common.ValidateHelper;
import com.gn.controller.MatchController;
import com.gn.controller.UserController;
import com.gn.enums.InputType;
import com.gn.model.vo.Message;
import com.gn.model.vo.SecureAuth;
import com.gn.model.vo.UserProfile;
import com.gn.model.vo.UserWithProfile;

public class MatchView {
	private UserController userController;
	private MatchController matchController;
	private SecureAuth userSession;
	private Scanner scanner;
	private ValidateHelper validateHelper;
	private static final int PAGE_SIZE = 2;

	public MatchView(UserController userController, MatchController matchController, SecureAuth userSession) {
		this.userController = userController;
		this.matchController = matchController;
		this.userSession = userSession;
		this.scanner = new Scanner(System.in);
		this.validateHelper = new ValidateHelper();
	}

	public void showMenu() {
		System.out.println("\n현재 로그인된 사용자: " + userSession.getUsername());
		while (true) {
			System.out.println("\n== 회원 매칭 메뉴 ==");
			System.out.println("1. 유저 검색");
			System.out.println("2. 받은 메시지 확인");
			// 찜확인,평점 확인 기능도 추가해야 하나??
			System.out.println("5. 종료");
			System.out.print("메뉴 선택 : ");
			int input = scanner.nextInt();
			scanner.nextLine();

			switch (input) {
			case 1:
				searchUsers();
				break;
			case 2:
				viewMessages();
				break;
			case 5:
//				scanner.close();
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
	}

	private void searchUsers() {
		List<String> conditions = new ArrayList<String>();
		StringBuilder whereQuery = new StringBuilder();

		while (true) {
			try {
				int input = (Integer) validateHelper.getValidatedInput("검색 항목 선택( 1.나이 2.키 3.성별 4.흥미 5.mbti 6.검색 : ",
						InputType.INTEGER);

				if (input < 1 || input > 6) {
					System.out.println("1부터 6 사이의 숫자를 입력해주세요.");
					continue;
				}

				if (input == 1) {
					// 수정 필요
					// !!
					String year = (String) validateHelper.getValidatedInput("생년(년도 4자리) 입력 : ", InputType.STRING);
					conditions.add("YEAR(birth) = " + year);

				} else if (input == 2) {
					int height = (Integer) validateHelper.getValidatedInput("키 입력 : ", InputType.HEIGHT);
					int nextChoice;

					while (true) {
						nextChoice = (Integer) validateHelper.getValidatedInput("[1]이상/[2]이하 : ", InputType.INTEGER);
						if (nextChoice == 1) {
							conditions.add("height >= " + height);
							break;
						} else if (nextChoice == 2) {
							conditions.add("height <= " + height);
							break;
						} else {
							System.out.println("1 또는 2만 입력해주세요.");
						}
					}

				} else if (input == 3) {
					// 수정해야함
					int userId = userSession.getUserId();
					UserWithProfile userWithProfile = userController.getUsersWithProfileById(userId);
					UserProfile userProfile = userWithProfile.getUserProfile();
					String userGender = userProfile.getGender();

					// 수정 필요
					if (userGender.equals("male")) {
						conditions.add("gender = 'female'");
					} else if (userGender.equals("female")) {
						conditions.add("gender = 'male'");
					}

				} else if (input == 4) {
					// 수정해야함
					String interest = (String) validateHelper.getValidatedInput("흥미 검색 : ", InputType.STRING);
					conditions.add("interests = '" + interest + "'");
				} else if (input == 5) {
					String mbti = (String) validateHelper.getValidatedInput("mbti 검색 : ", InputType.MBTI);
					conditions.add("mbti = '" + mbti + "'");

				} else if (input == 6) {
					if (!conditions.isEmpty()) {
						whereQuery.append("WHERE ");
						whereQuery.append(String.join(" AND ", conditions));

						int page = 0;
						while (true) {
							List<UserWithProfile> searchingUsers = matchController.getSearchingUsers(whereQuery,PAGE_SIZE, page);
							if (searchingUsers.isEmpty()) {
								System.out.println("회원이 존재하지 않습니다.");
							} else {
								System.out.println("\n== 매칭할 유저 목록(페이지 " + (page + 1) + ") ==");
								for (UserWithProfile u : searchingUsers) {
									System.out.println("User ID : " + u.getUser().getUserId());
									System.out.println("성별 : " + u.getUserProfile().getGender());
									System.out.println("사진 : " + u.getUserProfile().getProfilePicture());
									System.out.println("자기소개 : " + u.getUserProfile().getBio());
									System.out.println("-----------------------");
								}
							}
							System.out.println("\n1. 다음 페이지 | 2. 이전 페이지 | 3. 상세정보 조회 | 4. 종료");
							System.out.println("메뉴 선택: ");
							int number = scanner.nextInt();
							scanner.nextLine();

							if (number == 1) {
								searchingUsers = matchController.getSearchingUsers(whereQuery, PAGE_SIZE, page + 1);
								if (!searchingUsers.isEmpty()) {
									page++;
								} else {
									System.out.println("마지막 페이지 입니다.");
								}
							} else if (number == 2) {
								page = Math.max(0, page - 1);
							} else if (number == 3) {
								viewTargetUserDetails();
							} else if (number == 4) {
								return;
							} else {
								System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
							}
//						break;
						}
					} else {
						System.out.println("검색 항목을 선택해주세요.");
					}
				}
			} catch (Exception e) {
				System.out.println("처리 중 오류가 발생했습니다. 다시 시도해주세요.");
				e.printStackTrace();
				scanner.nextLine();
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
			System.out.println("User ID : " + userWithProfile.getUser().getUserId());
			System.out.println("User Name : " + userWithProfile.getUser().getUsername());
			System.out.println("생년 : " + userWithProfile.getUserProfile().getBirth().getYear());
			System.out.println("키 : " + userWithProfile.getUserProfile().getHeight());
			System.out.println("흥미 : " + userWithProfile.getUserProfile().getInterests());
			System.out.println("MBTI : " + userWithProfile.getUserProfile().getMbti());
			System.out.println("-----------------------");

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
					return;
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
			rating = (Integer) validateHelper.getValidatedInput("평점 입력(최저:1 ~ 최고:5) : ", InputType.INTEGER);
			if (1 <= rating && rating <= 5) {
				break;
			} else {
				System.out.println("잘못된 입력입니다. 1부터 5사이의 값을 입력해주세요.");
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

}
