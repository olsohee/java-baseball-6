package baseball.domain;

public class Result {

    private int strike;
    private int ball;

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
        if (strike == 3) {
            return true;
        }
        return false;
    }

    public void clear() {
        strike = ball = 0;
    }
}
