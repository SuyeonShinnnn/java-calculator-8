package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    private String separator;
    private String expression;

    public Calculator() { this.separator = ",|:"; }

    public void runCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        try{
            searchSeperator(input); // 구분자 찾기

            String[] splitExpression = splitInputByBasicRegex(); // 구분자 기준으로 문자열 분리

            int[] numbers = convertStringToInteger(splitExpression); // 문자열 -> 숫자 변환
            int result = sumNumbers(numbers); // 숫자 합 계산
            System.out.println("결과 : " + result); // 결과 출력
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    /**
     * 구분자 찾기
     * @param input
     */
    public void searchSeperator(String input) {
        // 커스텀 구분자 사용 여부 확인 후 separator, expression 초기화
        if(isCustomSeperator(input)) {
            String[] parts = input.split("\\\\n"); // "\n" 기준으로 분리
            this.separator = parts[0].substring(2); // "//" 제거
            this.expression = parts[1];
        }
        else {
            this.separator = ",|:";
            this.expression = input;
        }
    }

    /**
     * 커스텀 구분자 여부 확인
     * @param input
     * @return
     */
    public boolean isCustomSeperator(String input) {
        return input.startsWith("//") && input.split("\\\\n").length == 2;
    }

    /**
     * 구분자 기준으로 split
     * @return
     */
    public String[] splitInputByBasicRegex() {
        return expression.split(separator);
    }

    /**
     * String -> Integer 변환
     * @param inputs
     * @return
     * @throws IllegalArgumentException
     */
    public int[] convertStringToInteger(String[] inputs) throws IllegalArgumentException{
        int[] numbers = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++) {
            try{
                numbers[i] = Integer.parseInt(inputs[i]);
            } catch (NumberFormatException e) {
                ExceptionHandler.NOT_A_NUMBER.throwException();
            }
            if(!isProperNumber(numbers[i])) {
                ExceptionHandler.INVALID_NUMBER.throwException();
            }
        }
        return numbers;
    }

    /**
     * [입력값 검증]
     * 0 이상의 정수인지 확인
     * @param number
     * @return
     */
    public boolean isProperNumber(int number) {
        if(number < 0) {
            return false;
        }
        return true;
    }

    /**
     * 합 결과 return
     * @param nums
     * @return
     */
    public int sumNumbers(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        return sum;
    }
}
