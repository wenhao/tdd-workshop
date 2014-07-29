package com.github.wenhao.tdd.guess.number;


import com.github.wenhao.tdd.guess.number.domain.Answer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class AnswerGeneratorTest
{

    private AnswerGenerator answerGenerator;

    @Before
    public void setUp() throws Exception
    {
        answerGenerator = new AnswerGenerator();
    }

    @Test
    public void should_be_able_to_generate_answer() throws Exception
    {
        // when
        Answer answer = answerGenerator.generate();

        // then
        assertThat(answer, notNullValue());
    }

    @Test(expected = AnswerInvalidException.class)
    public void should_raise_error_if_generated_answer_is_invalid() throws Exception
    {
        // when
        answerGenerator.generate();
    }
}
