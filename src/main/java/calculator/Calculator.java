package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    private final String basicRegex = ",|:";

    public void runCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        String[] splitInputs = splitInputByBasicRegex(input);
        int[] numbers = convertStringToInteger(splitInputs);
        int result = sumNumbers(numbers);
        System.out.println(result);
    }

    public String[] splitInputByBasicRegex(String input) {
        return input.split(basicRegex);
    }

    public int[] convertStringToInteger(String[] inputs) {
        int[] numbers = new int[inputs.length];
        for(int i = 0; i < inputs.length; i++) {
            try{
                numbers[i] = Integer.parseInt(inputs[i]);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }

            if(!isProperNumber(numbers[i])) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
        return numbers;
    }

    public boolean isProperNumber(int number) {
        if(number < 0) {
            return false;
        }
        return true;
    }

    public int sumNumbers(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        return sum;
    }
}
