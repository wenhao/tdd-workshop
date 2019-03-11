package com.github.wenhao.tdd.guess.number.command;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInputCommandTest {
    @Test
    public void should_be_able_to_get_input() throws Exception {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("1 2 3 4");

        // when
        ConsoleInputCommand consoleInputCommand = new ConsoleInputCommand(bufferedReader);

        // then
        assertThat(consoleInputCommand.input().getValue()).isEqualTo("1 2 3 4");
    }

    @Test
    public void should_raise_error() throws Exception {
        // given
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenThrow(new IOException());

        // when
        ConsoleInputCommand consoleInputCommand = new ConsoleInputCommand(bufferedReader);
        assertThrows(RuntimeException.class, consoleInputCommand::input);
    }
}
