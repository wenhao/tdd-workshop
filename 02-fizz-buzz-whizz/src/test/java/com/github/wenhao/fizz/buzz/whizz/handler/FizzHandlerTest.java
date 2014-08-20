package com.github.wenhao.fizz.buzz.whizz.handler;

import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FizzHandlerTest
{

    private FizzHandler fizzHandler;

    @Before
    public void setUp() throws Exception
    {
        fizzHandler = new FizzHandler(new BuzzHandler(null));
    }

    @Test
    public void should_be_able_to_return_fizz_when_student_count_is_multiple_of_3() throws Exception
    {
        // when
        String result = fizzHandler.handle(3);

        // then
        assertThat(result, is(FIZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String result = fizzHandler.handle(5);

        // then
        assertThat(result, is(BUZZ));
    }
}