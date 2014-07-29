package com.github.wenhao.tdd.guess.number.domain;

import com.github.wenhao.tdd.guess.number.exception.AnswerLengthInvalidException;
import com.github.wenhao.tdd.guess.number.exception.AnswerOutOfRangeException;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Range;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.newArrayList;

public class Answer
{
    private static final String SEPARATOR = " ";
    private static final int SIZE = 4;
    private static final String CORRECT_NUMBER = "A";
    private static final String MIX_NUMBER = "B";
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
        final List<String> actualNumbers = newArrayList(value.split(SEPARATOR));
        final List<String> inputNumbers = newArrayList(answer.value.split(SEPARATOR));
        return new StringBuilder()
                .append(correctNumber(actualNumbers, inputNumbers))
                .append(CORRECT_NUMBER)
                .append(mixNumber(actualNumbers, inputNumbers))
                .append(MIX_NUMBER).toString();
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

    public static void validate(Answer answer)
    {
        List<String> numbers = newArrayList(answer.value.split(SEPARATOR));

        boolean isBetween0And9 = Iterators.all(numbers.iterator(), new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return Range.closed(0, 9).contains(Integer.valueOf(number));
            }
        });
        if (!isBetween0And9) {
            throw new AnswerOutOfRangeException();
        }
        if (numbers.size() != SIZE) {
            throw new AnswerLengthInvalidException();
        }

    }

}