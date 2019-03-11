package com.github.wenhao.tdd.guess.number.view;

import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ConsoleGameViewTest {

    private ConsoleGameView consoleGameView;

    @BeforeEach
    public void setUp() throws Exception {
        consoleGameView = new ConsoleGameView();
    }

    @Test
    public void should_be_able_to_show_message() throws Exception {
        // when
        consoleGameView.showMessage("message");
    }

    @Test
    public void should_be_able_to_show_current_result() throws Exception {
        // when
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer("1 2 3 4");
        guessResult.setResult("successful");
        consoleGameView.showCurrentResult(guessResult);
    }

    @Test
    public void should_be_able_to_show_guess_results() throws Exception {
        // when
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer("1 2 3 4");
        guessResult.setResult("successful");
        consoleGameView.showGuessHistory(Arrays.asList(guessResult));
    }
}
