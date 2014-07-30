package com.github.wenhao.tdd.guess.number.generator;

import com.github.wenhao.tdd.guess.number.domain.Answer;

public class AnswerGenerator
{
    private RandomIntGenerator randomIntGenerator;

    public AnswerGenerator(RandomIntGenerator randomIntGenerator)
    {
        this.randomIntGenerator = randomIntGenerator;
    }

    public Answer generate()
    {
        Answer answer = Answer.createAnswer(randomIntGenerator.nextInt());
        Answer.validate(answer);
        return answer;
    }
}
