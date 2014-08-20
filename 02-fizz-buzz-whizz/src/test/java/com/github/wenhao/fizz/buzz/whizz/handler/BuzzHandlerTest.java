package com.github.wenhao.fizz.buzz.whizz.handler;

import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BuzzHandlerTest
{

    private BuzzHandler buzzHandler;

    @Before
    public void setUp() throws Exception
    {
        buzzHandler = new BuzzHandler(new WhizzHandler(null));
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