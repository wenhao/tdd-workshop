package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuzzHandlerTest
{

    private BuzzHandler buzzHandler;

    @Before
    public void setUp() throws Exception
    {
        Words words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        buzzHandler = new BuzzHandler(new WhizzHandler(null, words), words);
    }

    @Test
    public void should_be_able_to_return_Buzz_when_student_count_is_multiple_of_5() throws Exception
    {
        // when
        String result = buzzHandler.handle(5);

        // then
        assertThat(result, is(BUZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String result = buzzHandler.handle(7);

        // then
        assertThat(result, is(WHIZZ));
    }
}