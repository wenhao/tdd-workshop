package com.github.wenhao.tdd.guess.number;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.domain.Game;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest
{
    @Test
    public void should_return_0A0B_if_no_number_is_correct() throws Exception
    {
        // given
        Answer actualAnswer = Answer.createAnswer("1 2 3 4");
        Game game = new Game(actualAnswer);
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        // when
        String result = game.guess(inputAnswer);

        // then
        assertThat(result, is("0A0B"));
    }

}
