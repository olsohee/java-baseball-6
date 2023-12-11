package baseball.view;

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

    public void printStartMessage() {
        System.out.println(OutputMessage.START_MESSAGE.getMessage());
    }
}
