package com.gn.controller;

import java.util.ArrayList;
import java.util.List;
import com.gn.model.vo.MbtiQuestion;

public class MbtiTestController {
	private List<MbtiQuestion> questions;

	public MbtiTestController() {
		initializeQuestions();
	}

	private void initializeQuestions() {
		questions = new ArrayList<>();

		questions.add(new MbtiQuestion(1, "애인과 함께할 때, 더 좋은 상황은?", 
				"여러 사람과 어울리며 함께 노는 것", 
				"조용한 곳에서 둘만의 시간을 보내는 것", 
				"EI"));

		questions.add(new MbtiQuestion(2, "애인과 데이트할 때, 더 좋은 계획은?", 
				"미리 철저하게 계획을 세운 데이트", 
				"즉흥적으로 떠나는 데이트", 
				"JP"));

		questions.add(new MbtiQuestion(3, "고민이 있을 때, 더 좋은 애인의 반응은?", 
				"해결책을 제시하고 조언한다", 
				"공감하고 위로해준다", 
				"TF"));

		questions.add(new MbtiQuestion(4, "애인과의 대화 스타일 중 더 좋은 것은?", 
				"현실적이고 구체적인 이야기를 나누는 것", 
				"미래의 가능성과 새로운 아이디어를 이야기하는 것", 
				"SN"));

		questions.add(new MbtiQuestion(5, "더 끌리는 애인의 성격은?", 
				"활발하고 사교적인 사람", 
				"조용하고 차분한 사람", 
				"EI"));

		questions.add(new MbtiQuestion(6, "스타일이 더 맞는 애인은?", 
				"합리적인 사람", 
				"따뜻한 사람",
				"TF"));

		questions.add(new MbtiQuestion(7, "선호하는 여행은?", 
				"세부 일정까지 철저히 짜는 여행", 
				"즉흥적으로 떠나는 여행", 
				"JP"));

		questions.add(new MbtiQuestion(8, "선호하는 데이트 장소는?", 
				"익숙하고 안정적인 환경", 
				"새롭고 자극적인 환경", 
				"SN"));

		questions.add(new MbtiQuestion(9, "애인에게 더 바라는 성향은?", 
				"주변 사람들과 잘 어울리는 사람", 
				"나와 깊이 있는 대화를 하는 사람", 
				"EI"));

		questions.add(new MbtiQuestion(10, "다퉜을 때, 더 선호하는 애인의 반응은?", 
				"침착하게 원인과 조율점을 말한다", 
				"자신의 감정을 솔직하게 표현하고 공감한다", 
				"TF"));

		questions.add(new MbtiQuestion(11, "애인과 함께 새로운 곳에 갔을 때, 더 좋은 반응은?", 
				"세부 사항을 꼼꼼하게 확인한다", 
				"새로운 환경에 직감적으로 대응한다", 
				"SN"));

		questions.add(new MbtiQuestion(12, "데이트 중 일정이 틀어졌을 때, 더 끌리는 방식은?", 
				"새로운 일정을 다시 계획한다",
				"발길이 닿는 곳으로 간다", 
				"JP"));

	}

	public List<MbtiQuestion> getQuestions() {
		return questions;
	}
}
