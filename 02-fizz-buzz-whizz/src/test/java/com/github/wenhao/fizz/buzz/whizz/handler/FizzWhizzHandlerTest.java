package com.github.wenhao.fizz.buzz.whizz.handler;

import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_WHIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzWhizzHandlerTest
{

    private FizzWhizzHandler fizzWhizzHandler;

    @Before
    public void setUp() throws Exception
    {
        fizzWhizzHandler = new FizzWhizzHandler(new FizzHandler(new BuzzHandler(new WhizzHandler(null))));
    }

    @Test
    public void should_be_able_to_return_fizz_whizz_when_student_count_is_multiple_of_3_and_7() throws Exception
    {
        // when
        String result = fizzWhizzHandler.handle(21);

        // then
        assertThat(result, is(FIZZ_WHIZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String fizz = fizzWhizzHandler.handle(3);
        String buzz = fizzWhizzHandler.handle(5);
        String whizz = fizzWhizzHandler.handle(7);

        // then
        assertThat(fizz, is(FIZZ));
        assertThat(buzz, is(BUZZ));
        assertThat(whizz, is(WHIZZ));
    }
}