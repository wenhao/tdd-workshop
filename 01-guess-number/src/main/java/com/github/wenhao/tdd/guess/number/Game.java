package com.github.wenhao.tdd.guess.number;

import com.github.wenhao.tdd.guess.number.domain.Answer;

public class Game
{
    private Answer answer;
    private AnswerGenerator answerGenerator;

    public Game(AnswerGenerator answerGenerator)
    {
        this.answerGenerator = answerGenerator;
        this.answer = answerGenerator.generate();
    }

    public String guess(Answer answer)
    {
        return this.answer.compare(answer);
    }
}
