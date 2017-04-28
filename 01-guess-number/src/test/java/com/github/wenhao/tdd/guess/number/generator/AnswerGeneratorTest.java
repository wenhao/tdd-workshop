package com.github.wenhao.tdd.guess.number.generator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AnswerGeneratorTest
{

    @Test
    public void should_generator_answer()
    {
        // given
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.nextInt()).thenReturn(1, 2, 3, 4);
        final AnswerGenerator answerGenerator = new AnswerGenerator(randomIntGenerator);

        // when
        Answer answer = answerGenerator.generate();

        // then
        assertThat(answer.getValue(), is("1 2 3 4"));
    }
}
