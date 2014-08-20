package com.github.wenhao.fizz.buzz.whizz.handler;

import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzHandlerTest
{

    private FizzBuzzHandler fizzBuzzHandler;

    @Before
    public void setUp() throws Exception
    {
        fizzBuzzHandler = new FizzBuzzHandler(new FizzHandler(new BuzzHandler(new WhizzHandler(null))));
    }

    @Test
    public void should_be_able_to_return_fizz_buzz_when_student_count_is_multiple_of_3_and_5() throws Exception
    {
        // when
        String result = fizzBuzzHandler.handle(15);

        // then
        assertThat(result, is(FIZZ_BUZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String fizz = fizzBuzzHandler.handle(3);
        String buzz = fizzBuzzHandler.handle(5);
        String whizz = fizzBuzzHandler.handle(7);

        // then
        assertThat(fizz, is(FIZZ));
        assertThat(buzz, is(BUZZ));
        assertThat(whizz, is(WHIZZ));
    }
}