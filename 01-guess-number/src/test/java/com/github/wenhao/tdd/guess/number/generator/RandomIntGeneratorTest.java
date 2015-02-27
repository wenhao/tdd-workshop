package com.github.wenhao.tdd.guess.number.generator;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomIntGeneratorTest
{
    @Test
    public void should_be_able_to_generate_random_numbers() throws Exception
    {
        // given

        // when
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator(new Random());
        String number = randomIntGenerator.nextInt();

        // then
        assertThat(number.split(" ").length, is(4));
    }
}
