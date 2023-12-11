package baseball.message;

public enum ErrorMessage {

    INVALID_INPUT("잘못된 입력 값입니다."),
    INVALID_ANSWER("잘못된 정답 값입니다.")
    ;

    private static final String ERROR_HEADER = "[ERROR]";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return String.format("%s %s", ERROR_HEADER, errorMessage);
    }
}
