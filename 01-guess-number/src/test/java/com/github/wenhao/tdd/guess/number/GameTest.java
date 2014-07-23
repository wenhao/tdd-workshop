package com.github.wenhao.tdd.guess.number;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest
{

    private Game game;

    @Before
    public void setUp() throws Exception
    {
        game = new Game(Answer.createAnswer("1 2 3 4"));
    }

    @Test
    public void should_return_0A0B_if_no_number_is_correct() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        // when
        String result = game.guess(inputAnswer);

        // then
        assertThat(result, is("0A0B"));
    }

    @Test
    public void should_return_4A0B_if_all_number_are_correct() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");

        // when
        String result = game.guess(inputAnswer);

        // then
        assertThat(result, is("4A0B"));
    }

    @Test
    public void should_be_able_to_return_0A2B() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("2 4 7 8");

        // when
        String result = game.guess(inputAnswer);

        // then
        assertThat(result, is("0A2B"));
    }

    @Test
    public void should_be_able_to_return_1A2B() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("0 3 2 4");

        // when
        String result = game.guess(inputAnswer);

        // then
        assertThat(result, is("1A2B"));
    }

    @Test
    public void should_be_able_to_return_0A4B() throws Exception
    {
        // given
        Answer inputAnswer = Answer.createAnswer("4 3 2 1");

        // when
        String result = game.guess(inputAnswer);

        // then
        assertThat(result, is("0A4B"));
    }
}
