package com.gn.common;

import com.gn.enums.InputType;
import com.gn.enums.PaymentType;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateHelper {
	private Scanner scanner;

	public ValidateHelper() {
		this.scanner = new Scanner(System.in);
	}

	public Object getValidatedInput(String prompt, InputType type) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine().trim();
			try {
				switch (type) {
				case EMAIL:
					if (isValidEmail(input)) return input;
					break;
				case PASSWORD:
					if (isValidPassword(input)) return input;
					break;
				case DATE:
					if (isValidDate(input)) return LocalDate.parse(input);
					break;
				case HEIGHT:
					if (isValidHeight(input)) return Integer.parseInt(input);
					break;
				case GENDER:
					if (isValidGender(input)) return input.toLowerCase();
					break;
				case PHONE:
					if (isValidPhone(input)) return input;
					break;
				case MBTI:
					if (isValidMbti(input)) return input.toUpperCase();
					break;
				case STRING:
					if (isValidString(input)) return input;
					break;
				case INTEGER:
					if (isValidInteger(input)) return Integer.parseInt(input);
					break;
				default:
                    throw new UnsupportedOperationException("지원하지 않는 타입입니다.");
				}
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}

		}

	}

	public boolean isValidEmail(String email) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		boolean isValid = Pattern.matches(emailRegex, email);
		if (!isValid) {
			System.out.println("올바른 이메일 형식이 아닙니다.");
		}
		return isValid;
	}

	private boolean isValidPassword(String password) {
		if (password.length() < 8) {
			System.out.println("비밀번호는 8자리 이상이여야 합니다.");
			return false;
		}
		String passwordRegex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()-+=]).{8,}$";
		boolean isValid = Pattern.matches(passwordRegex, password);
		if (!isValid) {
			System.out.println("비밀번호는 영문자, 숫자, 특수문자를 포함하여야 합니다.");
		}
		return isValid;
	}

	private boolean isValidDate(String date) {
		try {
			LocalDate.parse(date);
			return true;
		} catch (DateTimeParseException e) {
			System.out.println("잘못된 날짜 형식입니다. (예: YYYY-MM-DD)");
			return false;
		}
	}

	private boolean isValidHeight(String tall) {
		try {
			int isValid = Integer.parseInt(tall);
			if (isValid < 100 || isValid > 250) {
				System.out.println("100 이상, 250 이하의 숫자만 입력 가능합니다.");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력할 수 있습니다.");
			return false;
		}
	}

	private boolean isValidGender(String gender) {
		String genderRegex = "^(?i)(male|female|other)$";
		boolean isValid = Pattern.matches(genderRegex, gender);
		if (!isValid) {
			System.out.println("성별은 \'male\', \'female\', \'other\'만 입력가능합니다.");
		}
		return isValid;
	}

	private boolean isValidPhone(String phone) {
		String phoneRegex = "^01(?:0|1|[6-9])-\\d{3,4}-\\d{4}$";
		boolean isValid = Pattern.matches(phoneRegex, phone);
		if (!isValid) {
			System.out.println("올바른 전화번호 형식이 아닙니다. (예: 000-0000-0000)");
		}
		return isValid;
	}

	private boolean isValidMbti(String mbti) {
		String mbtiRegex = "^(?i)(E|I)(N|S)(T|F)(P|J)$";
		boolean isValid = Pattern.matches(mbtiRegex, mbti);
		if (!isValid) {
			System.out.println("올바른 MBTI 형식이 아닙니다. (예: ENTJ)");
		}
		return isValid;
	}

	private boolean isValidString(String input) {
		if (input == null || input.isEmpty()) {
			System.out.println("값을 입력해주세요.");
			return false;
		}
		return true;
	}

	private boolean isValidInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력할 수 있습니다.");
			return false;
		}
	}


}
