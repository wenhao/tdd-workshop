package com.github.wenhao.tdd.guess.number.generator;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

import java.util.Random;
import java.util.Set;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_RANGE;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SIZE;
import static com.google.common.collect.Sets.newHashSet;

public class RandomIntGenerator
{
    private Random random;

    @Inject
    public RandomIntGenerator(Random random)
    {
        this.random = random;
    }

    public String nextInt()
    {
        Set<Integer> numbers = newHashSet();
        while (numbers.size() < ANSWER_SIZE) {
            numbers.add(random.nextInt(ANSWER_RANGE.upperEndpoint()) + ANSWER_RANGE.lowerEndpoint());
        }
        return Joiner.on(ANSWER_SEPARATOR).join(numbers);
    }
}
