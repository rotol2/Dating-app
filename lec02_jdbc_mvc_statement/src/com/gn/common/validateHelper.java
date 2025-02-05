package com.gn.common;

public class validateHelper {
	public int tryParseInt(String value, int defaultVal) {
		try {
			return Integer.parseInt(value);
		} catch(NumberFormatException e) {
			return defaultVal;
		}
	}
	
	public Boolean tryParseInt(String value) {
		try {
			int intValue = Integer.parseInt(value);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("숫자만 입력해주세요.");
			return false;
		}
	}
}
