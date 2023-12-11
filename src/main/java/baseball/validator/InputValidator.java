package baseball.validator;

import baseball.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private InputValidator() {
    }

    private static class InputValidatorHolder {
        private static InputValidator inputValidator = new InputValidator();
    }

    public static InputValidator getInstance() {
        return InputValidatorHolder.inputValidator;
    }

    public List<Integer> validateInputNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        try {
            numbers = Arrays.stream(inputNumbers.split(""))
                    .map((input -> Integer.parseInt(input)))
                    .toList();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        return numbers;
    }

    public int validateRetryCommand(String inputRetryCommand) {
        try {
            if (!inputRetryCommand.equals("1") && !inputRetryCommand.equals("2")) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
            }
            return Integer.parseInt(inputRetryCommand);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
    }
}
