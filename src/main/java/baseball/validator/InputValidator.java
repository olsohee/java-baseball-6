package baseball.validator;

import baseball.message.ErrorMessage;

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
        List<Integer> numbers;
        try {
            numbers = Arrays.stream(inputNumbers.split(""))
                    .map((input -> Integer.parseInt(input)))
                    .toList();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getErrorMessage());
        }
        return numbers;
    }
}
