package com.github.wenhao.tdd.guess.number.controller;

import com.github.wenhao.tdd.guess.number.command.InputCommand;
import com.github.wenhao.tdd.guess.number.domain.Answer;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.MAX_TIMES;
import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.github.wenhao.tdd.guess.number.service.Game;
import com.github.wenhao.tdd.guess.number.view.GameView;
import com.google.inject.Inject;

public class GameController {
    private Game game;
    private GameView gameView;
    private InputCommand inputCommand;

    @Inject
    public GameController(Game game, GameView gameView, InputCommand inputCommand) {
        this.game = game;
        this.gameView = gameView;
        this.inputCommand = inputCommand;
    }

    public void play() {
        GuessResult guessResult;
        do {
            Answer input = inputCommand.input();
            guessResult = game.guess(input);
            gameView.showCurrentResult(guessResult);
            gameView.showGuessHistory(game.getHistory());
        } while (!guessResult.correct() && game.getHistory().size() < MAX_TIMES);
        gameView.showMessage(guessResult.correct() ? "successful" : "failure");
        gameView.showMessage("The correct number is: " + game.actualAnswer());
    }
}
