package com.github.wenhao.tdd.guess.number.command;

import com.github.wenhao.tdd.guess.number.domain.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputCommand implements InputCommand
{
    @Override
    public Answer input()
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String answerString = bufferedReader.readLine();
            return Answer.createAnswer(answerString);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
