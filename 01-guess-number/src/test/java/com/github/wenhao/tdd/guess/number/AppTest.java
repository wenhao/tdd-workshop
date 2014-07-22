package com.github.wenhao.tdd.guess.number;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AppTest
{

    @Test
    public void should_be_able_to_run_junit_test() throws Exception
    {
        // given

        // when
        App app = new App();
        app.setName("test");

        // then
        assertThat(app.getName(), is("test"));
    }
}
