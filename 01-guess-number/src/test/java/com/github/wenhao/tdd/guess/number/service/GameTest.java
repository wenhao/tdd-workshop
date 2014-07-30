package com.github.wenhao.tdd.guess.number.service;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest
{

    private Game game;

    @Before
    public void setUp() throws Exception
    {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        game = new Game(answerGenerator);
    }

    @Test
    public void should_return_0A0B_if_no_number_is_correct() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult(), is("0A0B"));
    }

    @Test
    public void should_return_4A0B_if_all_number_are_correct() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult(), is("4A0B"));
    }

    @Test
    public void should_be_able_to_return_0A2B() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("2 4 7 8");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult(), is("0A2B"));
    }

    @Test
    public void should_be_able_to_return_1A2B() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("0 3 2 4");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult(), is("1A2B"));
    }

    @Test
    public void should_be_able_to_return_0A4B() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("4 3 2 1");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult(), is("0A4B"));
    }

    @Test
    public void should_record_every_guess_result() throws Exception
    {
        // given
        game.guess(Answer.createAnswer("1 2 3 5"));
        game.guess(Answer.createAnswer("5 6 7 8"));

        // when
        List<GuessResult> guessResults = game.getHistory();

        // then
        assertThat(guessResults.size(), is(2));
        assertThat(guessResults.get(0).getResult(), is("3A0B"));
        assertThat(guessResults.get(0).getInputAnswer(), is("1 2 3 5"));
        assertThat(guessResults.get(1).getResult(), is("0A0B"));
        assertThat(guessResults.get(1).getInputAnswer(), is("5 6 7 8"));
    }
}
