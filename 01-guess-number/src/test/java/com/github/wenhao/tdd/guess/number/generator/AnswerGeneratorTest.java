package com.github.wenhao.tdd.guess.number.generator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.exception.AnswerNumberDuplicatedException;
import com.github.wenhao.tdd.guess.number.exception.AnswerNotFourDigitException;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest
{

    private AnswerValidator answerValidator;

    @Before
    public void setUp() throws Exception
    {
        answerValidator = new AnswerValidator();
    }

    @Test
    public void should_be_able_to_generate_answer() throws Exception
    {
        // given
        AnswerGenerator answerGenerator = new AnswerGenerator(new RandomIntGenerator(new Random()), answerValidator);

        // when
        Answer answer = answerGenerator.generate();

        // then
        assertThat(answer, notNullValue());
    }

    @Test(expected = AnswerNotFourDigitException.class)
    public void should_raise_error_out_of_range_answer_exception_which_is_not_between_0_and_9() throws Exception
    {
        // given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn("1 2 3 10");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator, answerValidator);

        // when
        answerGenerator.generate();
    }

    @Test(expected = AnswerNumberDuplicatedException.class)
    public void should_raise_error_which_size_is_not_4() throws Exception
    {
        // given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn("1 2 3");
        AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator, answerValidator);

        // when
        answerGenerator.generate();
    }
}
