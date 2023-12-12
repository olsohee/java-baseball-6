package baseball.controller;

import baseball.service.Service;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView inputView;
    private final InputValidator inputValidator;
    private final OutputView outputView;
    private final Service service;
    private boolean isEnd = false;
    private GameCommand gameCommand = GameCommand.CONTINUE;

    public Controller(InputView inputView, InputValidator inputValidator, OutputView outputView) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
        this.outputView = outputView;
        this.service = new Service();
    }

    public void start() {
        outputView.printStartMessage();
        while (gameCommand == GameCommand.CONTINUE) {
            service.createAnswerBalls();
            do {
                play();
                isEnd = service.isEnd();
            } while (!isEnd);

            outputView.printEndMessage();
            readRetry();
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

    private void play() {
        try {
            List<Integer> numbers = inputValidator.validateInputNumbers(inputView.readNumber());
            service.createUserBalls(numbers);
            service.getResult();
            outputView.printResult(service.getResultDto());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            play();
        }
    }
}
