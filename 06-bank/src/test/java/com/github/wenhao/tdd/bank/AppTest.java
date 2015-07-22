package com.github.wenhao.tdd.bank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class AppTest
{
    @Test
    public void should_be_able_to_run_junit_test()
    {
        // given

        // when
        App app = new App();

        // then
        assertThat(app.getName()).isEqualTo("junit");
    }
}
