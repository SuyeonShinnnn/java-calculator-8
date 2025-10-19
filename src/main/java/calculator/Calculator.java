package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    private String input;
    private final String basicRegex = ",|:";

    public void runCalculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = readLine();

        String[] numbers = splitInputs(input);
        for(String n : numbers){
            System.out.println(n);
        }
    }

    public String[] splitInputs(String input) {
        return input.split(basicRegex);
    }
}
