package com.github.wenhao.tdd.guess.number.generator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.Collectors;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SIZE;

public class AnswerGenerator
{
    private final RandomIntGenerator randomIntGenerator;

    public AnswerGenerator(RandomIntGenerator randomIntGenerator)
    {
        this.randomIntGenerator = randomIntGenerator;
    }

    public Answer generate()
    {
        Set<String> numbers = Sets.newHashSet();
        while (numbers.size() < ANSWER_SIZE) {
            numbers.add(randomIntGenerator.nextInt() + "");
        }
        String answerString = numbers.stream().collect(Collectors.joining(" "));
        return new Answer(answerString);
    }

}
