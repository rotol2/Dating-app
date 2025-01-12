package com.gn.model.dao;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenericHelper {

    private Scanner scanner;

    public GenericHelper() {
        this.scanner = new Scanner(System.in);
    }

    public enum InputType {
        STRING, INTEGER, LOCAL_DATE
    }

    public <T> T getInput(String prompt, InputType type, Class<T> clazz) {
        while (true) {
            System.out.print(prompt);
            try {
                switch (type) {
                    case STRING:
                        String stringInput = scanner.nextLine();
                        if (stringInput.trim().isEmpty()) {
                            throw new IllegalArgumentException("입력값은 비워둘 수 없습니다.");
                        }
                        return clazz.cast(stringInput); //stringInput을 clazz(=String)타입으로 반환

                    case INTEGER:
                        int intInput = scanner.nextInt();
                        scanner.nextLine();
                        if (intInput <= 0) {
                            throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
                        }
                        return clazz.cast(intInput);

                    case LOCAL_DATE:
                        String dateInput = scanner.nextLine();
                        LocalDate date = LocalDate.parse(dateInput);
                        return clazz.cast(date);

                    default:
                        throw new UnsupportedOperationException("지원하지 않는 타입입니다.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("잘못된 날짜 형식입니다. (예: YYYY-MM-DD)");
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력할 수 있습니다.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("알 수 없는 오류가 발생했습니다.");
            }
        }
    }
}
