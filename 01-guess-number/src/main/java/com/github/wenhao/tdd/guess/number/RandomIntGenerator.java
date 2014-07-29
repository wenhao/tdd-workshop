package com.github.wenhao.tdd.guess.number;

import com.google.common.base.Joiner;

import java.util.Random;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class RandomIntGenerator
{
    private static final Integer SIZE = 4;
    private Random random;

    public RandomIntGenerator(Random random)
    {
        this.random = random;
    }

    public String nextInt()
    {
        Set<Integer> numbers = newHashSet();
        while (numbers.size() < SIZE) {
            numbers.add(random.nextInt(10));
        }
        return Joiner.on(" ").join(numbers);
    }
}
