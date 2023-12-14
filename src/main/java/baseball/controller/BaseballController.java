package baseball.controller;

import baseball.service.BaseballService;
import baseball.convertor.InputConvertor;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {

    private final InputView inputView = InputView.getInstance();
    private final InputConvertor inputConvertor = InputConvertor.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final BaseballService baseballService = BaseballService.getInstance();
    private boolean isEnd = false;
    private GameCommand gameCommand = GameCommand.CONTINUE;


    public void run() {
        outputView.printStartMessage();
        while (gameCommand == GameCommand.CONTINUE) {
            baseballService.createAnswerBalls();
            do {
                play();
                isEnd = baseballService.isEnd();
            } while (!isEnd);

            outputView.printEndMessage();
            readRetry();
        }
    }

    private void play() {
        try {
            List<Integer> numbers = inputConvertor.convertToIntergerList(inputView.readNumber());
            baseballService.createUserBalls(numbers);
            baseballService.getResult();
            outputView.printResult(baseballService.getResultDto());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            play();
        }
    }

    private void readRetry() {
        try {
            gameCommand = GameCommand.getGameCommand(inputView.readRetry().trim());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            readRetry();
        }
    }
}
