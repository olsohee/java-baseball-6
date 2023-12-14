package baseball.convertor;

import baseball.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    private static InputConvertor inputConvertor = new InputConvertor();

    private InputConvertor() {
    }

    public static InputConvertor getInstance() {
        return inputConvertor;
    }

    public List<Integer> convertToIntergerList(String inputNumbers) {
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
