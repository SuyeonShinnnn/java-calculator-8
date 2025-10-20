package calculator;

public enum ExceptionHandler {
    INVALID_NUMBER("[ERROR] 숫자는 0 이상의 정수만 입력 가능합니다."),
    NOT_A_NUMBER("[ERROR] 입력된 값 중에 숫자가 아닌 문자가 포함되어 있습니다.");

    private final String message;

    ExceptionHandler(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    // 이 enum 상수에 해당하는 IllegalArgumentException을 발생시키는 메서드
    public void throwException() {
        throw new IllegalArgumentException(this.message);
    }
}
