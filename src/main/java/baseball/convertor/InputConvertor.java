package baseball.convertor;

import baseball.message.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputConvertor {

    private InputConvertor() {
    }

    private static class InputConvertorHolder {
        private static InputConvertor inputConvertor = new InputConvertor();
    }

    public static InputConvertor getInstance() {
        return InputConvertorHolder.inputConvertor;
    }

    public List<Integer> convertToIntergerList(String inputNumbers) {
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
}
