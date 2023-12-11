package baseball.message;

public enum OutputMessage {

    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    BALL("%s볼"),
    STRIKE("%s스트라이크"),
    NOTHING("낫싱"),
    FINAL_RESULT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
