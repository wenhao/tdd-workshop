package com.github.wenhao.tdd.guess.number.view;

import com.github.wenhao.tdd.guess.number.domain.GuessResult;

import java.util.List;

public interface GameView {
    void showGuessHistory(List<GuessResult> guessResults);

    void showMessage(String message);

    void showCurrentResult(GuessResult guessResult);
}
