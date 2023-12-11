package baseball.view;

import baseball.dto.ResultDto;
import baseball.message.OutputMessage;

public class OutputView {


    private OutputView() {
    }

    private static class OutputViewHolder {
        private static OutputView outputView = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHolder.outputView;
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printStartMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }

    public void printResult(ResultDto resultDto) {
        if (resultDto.getStrikeCount() == 0 && resultDto.getBallCount() == 0) {
            System.out.println(OutputMessage.NOTHING.getMessage());
            return;
        }
        if (resultDto.getStrikeCount() == 0) {
            System.out.println(String.format(OutputMessage.BALL.getMessage(), resultDto.getBallCount()));
            return;
        }
        if (resultDto.getBallCount() == 0) {
            System.out.println(String.format(OutputMessage.STRIKE.getMessage(), resultDto.getStrikeCount()));
            return;
        }
        System.out.print(String.format(OutputMessage.BALL.getMessage(), resultDto.getBallCount()) + " ");
        System.out.println(String.format(String.format(OutputMessage.STRIKE.getMessage(), resultDto.getStrikeCount())));
    }

    public void printEndMessage() {
        System.out.println(OutputMessage.FINAL_RESULT.getMessage());
    }
}
