package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    private String seperator;
    private String expression;

    public Calculator() { this.seperator = ",|:"; }

    public void runCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        searchSeperator(input);

        String[] splitExpression = splitInputByBasicRegex();
        int[] numbers = convertStringToInteger(splitExpression);
        int result = sumNumbers(numbers);
        System.out.println("결과 : " + result);
    }

    public void searchSeperator(String input) {
        if(isCustomSeperator(input)) {
            setCustomSeperator(input);
        }
        else {
            expression = input;
        }
    }

    public boolean isCustomSeperator(String input) {
        if(!input.startsWith("//")) return false;
        if(input.split("\\\\n").length != 2) return false;
        return true;
    }

    public void setCustomSeperator(String input) {
        String[] i = input.split("\\\\n");
        seperator = i[0].split("//")[1];
        expression =  i[1];
    }

    public String[] splitInputByBasicRegex() {
        return expression.split(seperator);
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
