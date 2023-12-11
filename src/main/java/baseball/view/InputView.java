package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_NUMBER = "숫자를 입력해주세요 : ";

    private InputView() {
    }

    private static class InputViewHolder {
        private static InputView inputView = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHolder.inputView;
    }

    public String readNumber() {
        System.out.print(READ_NUMBER);
        return Console.readLine();
    }
}
