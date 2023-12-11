package baseball.domain;

import baseball.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class UserBalls {

    private List<Ball> userBalls = new ArrayList<>();
    private static final int NUMBER_COUNT = 3;

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
        if (numbers.size() != NUMBER_COUNT) {
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

    public List<Ball> getUserBalls() {
        return userBalls;
    }

    public void clear() {
        userBalls = new ArrayList<>();
    }
}
