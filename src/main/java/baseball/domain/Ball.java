package baseball.domain;

import baseball.message.ErrorMessage;

public class Ball {

    private int ball;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public Ball(int number) {
        validate(number);
        this.ball = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER.getErrorMessage());
        }
    }

    public int getBall() {
        return ball;
    }
}
