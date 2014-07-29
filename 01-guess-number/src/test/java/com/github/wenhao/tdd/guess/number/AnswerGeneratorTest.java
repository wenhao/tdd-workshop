package com.github.wenhao.tdd.guess.number;

import com.github.wenhao.tdd.guess.number.exception.OutOfRangeAnswerException;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest
{

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_raise_out_of_range_answer_exception_which_is_not_between_0_and_9() throws Exception
    {
        // given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn("1 2 3 10");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        // when
        answerGenerator.generate();
    }
}
