package com.github.wenhao.tdd.guess.number.command;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleInputCommandTest
{
    @Test
    public void should_be_able_to_get_input() throws Exception
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1 2 3 4");

        // when
        ConsoleInputCommand consoleInputCommand = new ConsoleInputCommand(bufferedReader);

        // then
        assertThat(consoleInputCommand.input().getValue(), is("1 2 3 4"));
    }

    @Test(expected = RuntimeException.class)
    public void should_raise_error() throws Exception
    {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenThrow(new IOException());

        // when
        ConsoleInputCommand consoleInputCommand = new ConsoleInputCommand(bufferedReader);
        consoleInputCommand.input();
    }
}
