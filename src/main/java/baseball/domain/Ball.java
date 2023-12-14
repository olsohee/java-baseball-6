package baseball.domain;

import baseball.message.ErrorMessage;

import static baseball.constant.BaseballInfo.*;

public class Ball {

    private int ball;

    public Ball(int number) {
        validate(number);
        this.ball = number;
    }

    private void validate(int number) {
        if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER.getErrorMessage());
        }
    }

    public boolean isMatch(Ball other) {
        if (other.ball == ball) {
            return true;
        }
        return false;
    }
}
