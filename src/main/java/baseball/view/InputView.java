package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static InputView inputView = new InputView();
    private static final String READ_NUMBER = "숫자를 입력해주세요 : ";
    private static final String READ_RETRY_COMMAND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    private InputView() {
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String readNumber() {
        System.out.print(READ_NUMBER);
        return Console.readLine();
    }

    public String readRetry() {
        System.out.println(READ_RETRY_COMMAND);
        return Console.readLine();
    }
}
