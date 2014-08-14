package com.github.wenhao.tdd.guess.number.view;

import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.google.inject.Inject;

import java.util.List;

public class ConsoleGameView implements GameView
{
    @Inject
    public ConsoleGameView()
    {
    }

    @Override
    public void showGuessHistory(List<GuessResult> guessResults)
    {
        System.out.println("History: ");
        for (GuessResult guessResult : guessResults) {
            showCurrentResult(guessResult);
        }
    }

    @Override
    public void showMessage(String message)
    {
        System.out.println(message);
    }

    @Override
    public void showCurrentResult(GuessResult guessResult)
    {
        System.out.println(guessResult.getInputAnswer() + ":" + guessResult.getResult());
    }
}
