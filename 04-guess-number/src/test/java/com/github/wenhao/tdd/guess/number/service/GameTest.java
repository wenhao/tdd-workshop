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

package com.github.wenhao.tdd.guess.number.service;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() throws Exception {
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(Answer.createAnswer("1 2 3 4"));
        game = new Game(answerGenerator, new AnswerValidator());
    }

    @Test
    public void should_return_0A0B_if_no_number_is_correct() throws Exception {
        // given
        Answer inputAnswer = Answer.createAnswer("5 6 7 8");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult()).isEqualTo("0A0B");
    }

    @Test
    public void should_return_4A0B_if_all_number_are_correct() throws Exception {
        // given
        Answer inputAnswer = Answer.createAnswer("1 2 3 4");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult()).isEqualTo("4A0B");
    }

    @Test
    public void should_be_able_to_return_0A2B() throws Exception {
        // given
        Answer inputAnswer = Answer.createAnswer("2 4 7 8");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult()).isEqualTo("0A2B");
    }

    @Test
    public void should_be_able_to_return_1A2B() throws Exception {
        // given
        Answer inputAnswer = Answer.createAnswer("0 3 2 4");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult()).isEqualTo("1A2B");
    }

    @Test
    public void should_be_able_to_return_0A4B() throws Exception {
        // given
        Answer inputAnswer = Answer.createAnswer("4 3 2 1");

        // when
        GuessResult guessResult = game.guess(inputAnswer);

        // then
        assertThat(guessResult.getResult()).isEqualTo("0A4B");
    }

    @Test
    public void should_record_every_guess_result() throws Exception {
        // given
        game.guess(Answer.createAnswer("1 2 3 5"));
        game.guess(Answer.createAnswer("5 6 7 8"));

        // when
        List<GuessResult> guessResults = game.getHistory();

        // then
        assertThat(guessResults.size()).isEqualTo(2);
        assertThat(guessResults.get(0).getResult()).isEqualTo("3A0B");
        assertThat(guessResults.get(0).getInputAnswer()).isEqualTo("1 2 3 5");
        assertThat(guessResults.get(1).getResult()).isEqualTo("0A0B");
        assertThat(guessResults.get(1).getInputAnswer()).isEqualTo("5 6 7 8");
    }
}
