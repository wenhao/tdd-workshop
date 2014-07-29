package com.github.wenhao.tdd.guess.number;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.exception.AnswerLengthInvalidException;
import com.github.wenhao.tdd.guess.number.exception.AnswerOutOfRangeException;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest
{
    @Test
    public void should_be_able_to_generate_answer() throws Exception
    {
        // given
        AnswerGenerator answerGenerator = new AnswerGenerator(new RandomIntGenerator(new Random()));

        // when
        Answer answer = answerGenerator.generate();

        // then
        assertThat(answer, notNullValue());
    }

    @Test(expected = AnswerOutOfRangeException.class)
    public void should_raise_error_out_of_range_answer_exception_which_is_not_between_0_and_9() throws Exception
    {
        // given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn("1 2 3 10");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        // when
        answerGenerator.generate();
    }

    @Test(expected = AnswerLengthInvalidException.class)
    public void should_raise_error_which_size_is_not_4() throws Exception
    {
        // given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn("1 2 3");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        // when
        answerGenerator.generate();
    }
}
