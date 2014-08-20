package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ_WHIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FizzBuzzWhizzHandlerTest
{

    private FizzBuzzWhizzHandler fizzBuzzWhizzHandler;

    @Before
    public void setUp() throws Exception
    {
        Words words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        fizzBuzzWhizzHandler = new FizzBuzzWhizzHandler(new FizzHandler(new BuzzHandler(new WhizzHandler(null, words), words), words), words);
    }

    @Test
    public void should_be_able_to_return_fizz_buzz_whizz_when_student_count_is_multiple_of_3_and_5_and_7() throws Exception
    {
        // when
        String result = fizzBuzzWhizzHandler.handle(105);

        // then
        assertThat(result, is(FIZZ_BUZZ_WHIZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String fizz = fizzBuzzWhizzHandler.handle(3);
        String buzz = fizzBuzzWhizzHandler.handle(5);
        String whizz = fizzBuzzWhizzHandler.handle(7);

        // then
        assertThat(fizz, is(FIZZ));
        assertThat(buzz, is(BUZZ));
        assertThat(whizz, is(WHIZZ));
    }
}