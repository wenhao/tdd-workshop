package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ_WHIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuzzWhizzHandlerTest
{

    private BuzzWhizzHandler buzzWhizzHandler;
    private Words words;

    @Before
    public void setUp() throws Exception
    {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        buzzWhizzHandler = new BuzzWhizzHandler(new FizzHandler(new BuzzHandler(new WhizzHandler(null))));
    }

    @Test
    public void should_be_able_to_return_buzz_whizz_when_student_count_is_multiple_of_5_and_7() throws Exception
    {
        // when
        String result = buzzWhizzHandler.handle(140, words);

        // then
        assertThat(result, is(BUZZ_WHIZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String fizz = buzzWhizzHandler.handle(3, words);
        String buzz = buzzWhizzHandler.handle(5, words);
        String whizz = buzzWhizzHandler.handle(7, words);

        // then
        assertThat(fizz, is(FIZZ));
        assertThat(buzz, is(BUZZ));
        assertThat(whizz, is(WHIZZ));
    }
}