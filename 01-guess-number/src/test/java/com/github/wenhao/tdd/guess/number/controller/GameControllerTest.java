package com.github.wenhao.tdd.guess.number.controller;

import com.github.wenhao.tdd.guess.number.command.InputCommand;
import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import com.github.wenhao.tdd.guess.number.service.Game;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import com.github.wenhao.tdd.guess.number.view.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Matchers.anyList;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GameControllerTest
{

    private GameController gameController;
    @Mock
    private InputCommand inputCommand;
    @Mock
    private GameView gameView;
    @Mock
    private AnswerGenerator answerGenerator;

    @BeforeEach
    public void setUp()
    {
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        Game game = new Game(answerGenerator, new AnswerValidator());
        gameController = new GameController(game, gameView, inputCommand);
    }

    @Test
    public void should_be_able_to_show_history_message()
    {
        // given
        when(inputCommand.input()).thenReturn(Answer.createAnswer("5 6 7 8"));

        // when
        gameController.play();

        // then
        verify(gameView, times(6)).showGuessHistory(anyList());
    }

    @Test
    public void should_end_game_and_show_successful_message_when_first_round()
    {
        // given
        when(inputCommand.input()).thenReturn(Answer.createAnswer("1 2 3 4"));

        // when
        gameController.play();

        // then
        verify(inputCommand, times(1)).input();
        verify(gameView).showMessage("successful");
    }

    @Test
    public void should_end_game_and_show_failure_message_when_reach_maximum_times()
    {
        // given
        when(inputCommand.input()).thenReturn(Answer.createAnswer("5 6 7 8"));

        // when
        gameController.play();

        // then
        verify(inputCommand, times(6)).input();
        verify(gameView).showMessage("failure");
    }
}
