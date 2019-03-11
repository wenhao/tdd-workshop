/*
 * Copyright © 2019, Wen Hao <wenhao@126.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
