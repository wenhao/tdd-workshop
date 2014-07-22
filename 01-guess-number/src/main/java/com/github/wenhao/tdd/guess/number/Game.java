package com.github.wenhao.tdd.guess.number;

import com.github.wenhao.tdd.guess.number.domain.Answer;

public class Game
{
    private Answer answer;
    public Game(Answer answer)
    {
        this.answer = answer;
    }

    public String guess(Answer answer)
    {
        return this.answer.compare(answer);
    }
}
