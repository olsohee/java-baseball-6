package baseball.domain;

import baseball.message.ErrorMessage;

public class Ball {

    private int ball;

    public Ball(int number) {
        validate(number);
        this.ball = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER.getErrorMessage());
        }
    }
}
