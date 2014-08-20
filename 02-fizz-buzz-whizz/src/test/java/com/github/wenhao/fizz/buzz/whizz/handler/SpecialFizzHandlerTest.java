package com.github.wenhao.fizz.buzz.whizz.handler;

import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpecialFizzHandlerTest
{

    private SpecialFizzHandler specialFizzHandler;

    @Before
    public void setUp() throws Exception
    {
        specialFizzHandler = new SpecialFizzHandler(new BuzzHandler(null));
    }

    @Test
    public void should_be_able_to_return_fizz_when_student_count_contains_3() throws Exception
    {
        // when
        String result = specialFizzHandler.handle(35);

        // then
        assertThat(result, is(FIZZ));
    }

    @Test
    public void should_next_handler_process() throws Exception
    {
        // when
        String result = specialFizzHandler.handle(5);

        // then
        assertThat(result, is(BUZZ));
    }
}