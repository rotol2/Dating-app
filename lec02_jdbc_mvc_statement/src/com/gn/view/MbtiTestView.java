package com.gn.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import com.gn.controller.MbtiTestController;
import com.gn.model.vo.MbtiQuestion;

public class MbtiTestView {
    private Scanner scanner;
    private MbtiTestController mbtiTestController;

    public MbtiTestView() {
        this.scanner = new Scanner(System.in);
        this.mbtiTestController = new MbtiTestController();
    }

    public void startTest() {
        System.out.println("\n=== 이상형 MBTI 테스트 ===");

        Map<String, Integer> dimensionScores = new HashMap<>();
        dimensionScores.put("EI", 0);
        dimensionScores.put("SN", 0);
        dimensionScores.put("TF", 0);
        dimensionScores.put("JP", 0);

        List<MbtiQuestion> questions = mbtiTestController.getQuestions();

        for (MbtiQuestion question : questions) {
            System.out.println("\n" + question.getQuestion());
            System.out.println("A. " + question.getAnswerA());
            System.out.println("B. " + question.getAnswerB());

            String answer;
            while (true) {
                System.out.print("당신의 선택 (A/B): ");
                answer = scanner.nextLine().trim().toUpperCase();
                if (answer.equals("A") || answer.equals("B")) break;
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }

            if (answer.equals("A")) {
                dimensionScores.put(question.getDimension(), dimensionScores.get(question.getDimension()) + 1);
            }
        }

        String result = (dimensionScores.get("EI") >= 2 ? "E" : "I") +
                        (dimensionScores.get("SN") >= 2 ? "S" : "N") +
                        (dimensionScores.get("TF") >= 2 ? "T" : "F") +
                        (dimensionScores.get("JP") >= 2 ? "J" : "P");

        System.out.println("\n당신의 MBTI 결과: " + result + "\n");

    }
}
