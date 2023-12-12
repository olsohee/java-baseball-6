package baseball;

import baseball.controller.Controller;
import baseball.convertor.InputConvertor;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller(InputView.getInstance(), InputConvertor.getInstance(), OutputView.getInstance());
        controller.start();
    }
}
