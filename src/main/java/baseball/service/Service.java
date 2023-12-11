package baseball.service;

import baseball.domain.AnswerBalls;
import baseball.domain.Result;
import baseball.domain.UserBalls;
import baseball.dto.ResultDto;

import java.util.List;

public class Service {

    private AnswerBalls answerBalls;
    private UserBalls userBalls;
    private Result result;

    public void createAnswerBalls() {
        answerBalls = new AnswerBalls();
    }

    public void createUserBalls(List<Integer> numbers) {
        userBalls = new UserBalls(numbers);
    }

    public void getResult() {
        result = new Result(answerBalls.calculateStrike(userBalls.getUserBalls()), answerBalls.calculateBall(userBalls.getUserBalls()));
    }

    public ResultDto getResultDto() {
        return new ResultDto(result.getStrike(), result.getBall());
    }

    public boolean isEnd() {
        if (result.isEnd()) {
            return true;
        }
        return false;
    }
}
