package baseball.domain;

import baseball.constant.BaseballInfo;
import baseball.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.BaseballInfo.BALL_COUNT;

public class UserBalls {

    private List<Ball> userBalls;

    public UserBalls(List<Integer> numbers) {
        validate(numbers);
        userBalls = numbers.stream()
                .map(number -> new Ball(number))
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicated(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != BALL_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        List<Integer> nonDuplicatedNumbers = numbers.stream()
                .distinct()
                .toList();
        if (nonDuplicatedNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }

    public void clear() {
        userBalls = new ArrayList<>();
    }

    public List<Ball> getUserBalls() {
        return userBalls;
    }
}
