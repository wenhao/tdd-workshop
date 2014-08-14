package com.github.wenhao.tdd.guess.number.controller;

import com.github.wenhao.tdd.guess.number.command.InputCommand;
import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.github.wenhao.tdd.guess.number.service.Game;
import com.github.wenhao.tdd.guess.number.view.GameView;
import com.google.inject.Inject;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.MAX_TIMES;

public class GameController
{
    private Game game;
    private GameView gameView;

    @Inject
    public GameController(Game game, GameView gameView)
    {
        this.game = game;
        this.gameView = gameView;
    }

    public void play(InputCommand inputCommand)
    {
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
