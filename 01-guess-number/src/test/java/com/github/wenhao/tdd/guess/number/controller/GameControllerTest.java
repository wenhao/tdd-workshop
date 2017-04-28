package com.github.wenhao.tdd.guess.number.controller;

import com.github.wenhao.tdd.guess.number.command.InputCommand;
import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import com.github.wenhao.tdd.guess.number.service.Game;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import com.github.wenhao.tdd.guess.number.view.GameView;
import org.junit.Test;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.*;

public class GameControllerTest
{
    @Test
    public void should_be_able_to_show_history_message() throws Exception
    {
        // given
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input()).thenReturn(Answer.createAnswer("5 6 7 8"));
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator, new AnswerValidator());
        GameView gameView = mock(GameView.class);

        GameController gameController = new GameController(game, gameView, inputCommand);

        // when
        gameController.play();

        // then
        verify(gameView, times(6)).showGuessHistory(anyList());
    }

    @Test
    public void should_end_game_and_show_successful_message_when_first_round() throws Exception
    {
        // given
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator, new AnswerValidator());
        GameView gameView = mock(GameView.class);

        GameController gameController = new GameController(game, gameView, inputCommand);

        // when
        gameController.play();

        // then
        verify(inputCommand, times(1)).input();
        verify(gameView).showMessage("successful");
    }

    @Test
    public void should_end_game_and_show_failure_message_when_reach_maximum_times() throws Exception
    {
        // given
        InputCommand inputCommand = mock(InputCommand.class);
        when(inputCommand.input()).thenReturn(Answer.createAnswer("5 6 7 8"));
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator, new AnswerValidator());
        GameView gameView = mock(GameView.class);

        GameController gameController = new GameController(game, gameView, inputCommand);

        // when
        gameController.play();

        // then
        verify(inputCommand, times(6)).input();
        verify(gameView).showMessage("failure");
    }
}
