package com.gn.model.vo;

// lombok 쓰려면 꼭 import부터 !
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

// 이 골뱅이들도 꼭 해야함! 또 쓸만한 골뱅이(임포트)할거 있는지 찾아보기 !
@Getter
@Setter
@AllArgsConstructor
public class MbtiQuestion {
	private int questionId;
    private String question;
    private String answerA;
    private String answerB; 
    private String dimension; //mbti 성향(ex.E or I)
}
