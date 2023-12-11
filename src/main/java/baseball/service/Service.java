package baseball.service;

import baseball.domain.AnswerBalls;
import baseball.domain.UserBalls;

import java.util.List;

public class Service {

    private AnswerBalls answerBalls;
    private UserBalls userBalls;

    public void createAnswerBalls() {
        answerBalls = new AnswerBalls();
    }

    public void createUserBalls(List<Integer> numbers) {
        userBalls = new UserBalls(numbers);
    }
}
