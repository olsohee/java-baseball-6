package baseball.domain;

import baseball.generator.RandomNumberGenerator;

import java.util.List;

public class AnswerBalls {

    private List<Ball> answerBalls;
    private static final int NUMBER_COUNT = 3;

    public AnswerBalls() {
        answerBalls = RandomNumberGenerator.generateRandomNumber(NUMBER_COUNT).stream()
                .map(number -> new Ball(number))
                .toList();
    }

    public int calculateStrike(List<Ball> userBalls) {
        int strikeCount = 0;
        for (int i = 0; i < userBalls.size(); i++) {
            if (answerBalls.get(i) == userBalls.get(i)) {
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
                if (answerBalls.get(i) == userBalls.get(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }
}
