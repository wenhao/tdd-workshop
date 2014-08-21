package com.github.wenhao.fizz.buzz.whizz.handler;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DefaultHandlerTest
{
    @Test
    public void should_be_able_to_return_self_when_student_count_is_4() throws Exception
    {
        // given
        Integer number = 4;
        DefaultHandler defaultHandler = new DefaultHandler();

        // when
        String result = defaultHandler.handle(number, null);

        // then
        assertThat(result, is("4"));
    }

}