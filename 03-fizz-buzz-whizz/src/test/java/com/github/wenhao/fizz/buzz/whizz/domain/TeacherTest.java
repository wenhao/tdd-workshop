package com.github.wenhao.fizz.buzz.whizz.domain;

import com.github.wenhao.fizz.buzz.whizz.exception.IllegalWordsException;
import org.junit.Test;

public class TeacherTest
{
    @Test(expected = IllegalWordsException.class)
    public void should_raise_exception_when_less_than_three_numbers() throws Exception
    {
        // when
        new Teacher().say(1, 2);
    }

    @Test(expected = IllegalWordsException.class)
    public void should_raise_exception_when_greater_than_three_numbers() throws Exception
    {
        // when
        new Teacher().say(1, 2, 3, 4);
    }

    @Test(expected = IllegalWordsException.class)
    public void should_raise_exception_when_has_same_number() throws Exception
    {
        // when
        new Teacher().say(1, 1, 2);
    }

    @Test(expected = IllegalWordsException.class)
    public void should_raise_exception_when_number_bigger_than_ten() throws Exception
    {
        // when
        new Teacher().say(1, 11, 12);
    }
}