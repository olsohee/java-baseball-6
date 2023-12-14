package baseball.service;

import baseball.domain.AnswerBalls;
import baseball.domain.Result;
import baseball.domain.UserBalls;
import baseball.dto.ResultDto;

import java.util.List;

public class BaseballService {

    private static BaseballService baseballService = new BaseballService();
    private AnswerBalls answerBalls;
    private UserBalls userBalls;
    private Result result;

    private BaseballService() {
    }

    public static BaseballService getInstance() {
        return baseballService;
    }

    public void createAnswerBalls() {
        answerBalls = new AnswerBalls();
    }

    public void createUserBalls(List<Integer> numbers) {
        userBalls = new UserBalls(numbers);
    }

    public void getResult() {
        result = new Result(answerBalls.calculateStrike(userBalls.getUserBalls()), answerBalls.calculateBall(userBalls.getUserBalls()));
    }

    public boolean isEnd() {
        if (result.isEnd()) {
            return true;
        }
        return false;
    }

    public void retry() {
        answerBalls.clear();
        userBalls.clear();
        result.clear();
    }

    public ResultDto getResultDto() {
        return new ResultDto(result.getStrike(), result.getBall());
    }
}
