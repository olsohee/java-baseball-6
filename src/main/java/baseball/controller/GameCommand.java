package baseball.controller;

import baseball.message.ErrorMessage;

import java.util.Arrays;

public enum GameCommand {

    CONTINUE("1"),
    END("2");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand getGameCommand(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.getCommand().equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND.getErrorMessage()));
    }

    public String getCommand() {
        return command;
    }
}
