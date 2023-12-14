package baseball.constant;

public enum BaseballInfo {

    BALL_COUNT(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9)
    ;
    private final int value;

    BaseballInfo(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
