package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhizzHandlerTest
{

    private WhizzHandler whizzHandler;
    private Words words;

    @Before
    public void setUp() throws Exception
    {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        whizzHandler = new WhizzHandler(new FizzHandler(null));
    }

    @Test
    public void should_be_able_to_return_Whizz_when_student_count_is_multiple_of_7() throws Exception
    {
        // when
        String result = whizzHandler.handle(7, words);

        // then
        assertThat(result, is(WHIZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String result = whizzHandler.handle(3, words);

        // then
        assertThat(result, is(FIZZ));
    }

}