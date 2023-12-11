package baseball.domain;

public class Result {

    private int strike;
    private int ball;
    private static final int END_NUMBER = 3;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isEnd() {
        if (strike == END_NUMBER) {
            return true;
        }
        return false;
    }

    public void clear() {
        strike = ball = 0;
    }
}
