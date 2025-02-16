package com.gn.common;

import java.util.regex.Pattern;

public class ValidateHelper {
	
    // 정규식 패턴 정의
    private static final Pattern YEAR_PATTERN = Pattern.compile("^\\d{4}$");
    private static final Pattern HEIGHT_PATTERN = Pattern.compile("^\\d{3}$");
    private static final Pattern MBTI_PATTERN = Pattern.compile("^(E|I)(N|S)(F|T)(P|J)$", Pattern.CASE_INSENSITIVE); //Pattern 클래스의 대소문자 무시 옵션(CASE_INSENSITIVE)

    public boolean isValidYear(String year) {
        	return YEAR_PATTERN.matcher(year).matches();
    }
    
    public boolean isValidHeight(String height) {
    		return HEIGHT_PATTERN.matcher(height).matches();
    }
    
    public boolean isValidMbti(String mbti) {
    		return MBTI_PATTERN.matcher(mbti).matches();
    }
    
    
	
}
