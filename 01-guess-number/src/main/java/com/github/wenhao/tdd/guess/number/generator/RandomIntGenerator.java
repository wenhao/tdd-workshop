package com.github.wenhao.tdd.guess.number.generator;

import java.util.Random;

public class RandomIntGenerator
{
    public int nextInt()
    {
        return new Random().nextInt(10);
    }
}
