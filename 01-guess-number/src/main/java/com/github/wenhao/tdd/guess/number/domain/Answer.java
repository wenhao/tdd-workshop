package com.github.wenhao.tdd.guess.number.domain;

import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

public class Answer
{
    private String value;

    public Answer(String value)
    {
        this.value = value;
    }

    public static Answer createAnswer(String value)
    {
        return new Answer(value);
    }

    public String compare(Answer answer)
    {
        final List<String> actualNumbers = newArrayList(value.split(" "));
        final List<String> inputNumbers = newArrayList(answer.value.split(" "));
        return new StringBuilder()
                .append(correctNumber(actualNumbers, inputNumbers))
                .append("A")
                .append(mixNumber(actualNumbers, inputNumbers))
                .append("B").toString();
    }

    private Integer mixNumber(final List<String> actualNumbers, final List<String> inputNumbers)
    {
        return from(inputNumbers).filter(new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return actualNumbers.contains(number) && actualNumbers.indexOf(number) != inputNumbers.indexOf(number);
            }
        }).toList().size();
    }

    private Integer correctNumber(final List<String> actualNumbers, final List<String> inputNumbers)
    {
        return from(inputNumbers).filter(new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return actualNumbers.contains(number) && actualNumbers.indexOf(number) == inputNumbers.indexOf(number);
            }
        }).toList().size();
    }

    public Boolean isValid()
    {
        return null;
    }
}
