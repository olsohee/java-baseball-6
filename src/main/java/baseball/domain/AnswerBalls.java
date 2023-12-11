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
}
