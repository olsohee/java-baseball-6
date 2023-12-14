package baseball.domain;

import baseball.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.BaseballInfo.BALL_COUNT;

public class AnswerBalls {

    private List<Ball> answerBalls = new ArrayList<>();

    public AnswerBalls() {
        answerBalls = RandomNumberGenerator.generateRandomNumber(BALL_COUNT.getValue()).stream()
                .map(number -> new Ball(number))
                .toList();
    }

    public int calculateStrike(List<Ball> userBalls) {
        int strikeCount = 0;
        for (int i = 0; i < userBalls.size(); i++) {
            if (answerBalls.get(i).isMatch(userBalls.get(i))) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int calculateBall(List<Ball> userBalls) {
        int ballCount = 0;
        for (int i = 0; i < userBalls.size(); i++) {
            for (int j = 0; j < userBalls.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (answerBalls.get(i).isMatch(userBalls.get(j))) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public void clear() {
        answerBalls = new ArrayList<>();
    }
}
