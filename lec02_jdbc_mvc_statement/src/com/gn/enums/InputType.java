package com.gn.enums;

public enum InputType {
    EMAIL("이메일"),
    PASSWORD("비밀번호"),
    USERNAME("사용자명"),
    DATE("날짜"),
    HEIGHT("키"),
    GENDER("성별"),
    PHONE("전화번호"),
    ADDRESS("주소"),
    PROFILE_PIC("프로필 사진"),
    INTERESTS("관심사"),
    MBTI("MBTI"),
    BIO("자기소개"),
    STRING("문자열"),
    INTEGER("정수");

    private final String description;

    InputType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}