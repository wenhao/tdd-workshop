package com.github.wenhao.tdd.guess.number.generator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import com.google.inject.Inject;

public class AnswerGenerator
{
    private RandomIntGenerator randomIntGenerator;
    private AnswerValidator answerValidator;

    @Inject
    public AnswerGenerator(RandomIntGenerator randomIntGenerator, AnswerValidator answerValidator)
    {
        this.randomIntGenerator = randomIntGenerator;
        this.answerValidator = answerValidator;
    }

    public Answer generate()
    {
        Answer answer = Answer.createAnswer(randomIntGenerator.nextInt());
        answerValidator.validate(answer);
        return answer;
    }
}
