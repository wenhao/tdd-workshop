package com.github.wenhao.tdd.guess.number.command;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.google.inject.Inject;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInputCommand implements InputCommand {

    private BufferedReader bufferedReader;

    @Inject
    public ConsoleInputCommand(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public Answer input() {
        try {
            String answerString = bufferedReader.readLine();
            return Answer.createAnswer(answerString);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
