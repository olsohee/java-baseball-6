package baseball;

import baseball.controller.Controller;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(InputView.getInstance(), InputValidator.getInstance(), OutputView.getInstance());
        controller.start();
    }
}
