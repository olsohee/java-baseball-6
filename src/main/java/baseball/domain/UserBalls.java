package baseball.domain;

import baseball.message.ErrorMessage;

import java.util.List;

public class UserBalls {

    private List<Ball> userBalls;
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
        validateRange(numbers);
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

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 9) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
            }
        }
    }
}
