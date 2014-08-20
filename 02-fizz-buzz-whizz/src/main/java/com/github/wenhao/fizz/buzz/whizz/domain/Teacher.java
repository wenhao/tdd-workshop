package com.github.wenhao.fizz.buzz.whizz.domain;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Teacher
{
    private Words words;

    public Teacher()
    {
        words = new Words();
    }

    public void say(Integer... numbers)
    {
        List<Integer> number = newArrayList(numbers);
        words.setFirst(number.get(0));
        words.setSecond(number.get(1));
        words.setThird(number.get(2));
    }

    public Words getWords()
    {
        return words;
    }

}
