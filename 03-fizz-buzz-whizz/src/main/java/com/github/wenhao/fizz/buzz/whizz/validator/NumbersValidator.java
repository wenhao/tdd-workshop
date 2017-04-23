package com.github.wenhao.fizz.buzz.whizz.validator;

import com.github.wenhao.fizz.buzz.whizz.exception.IllegalWordsException;
import com.google.common.base.Predicate;
import com.google.common.collect.Range;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Sets.newHashSet;

public class NumbersValidator
{
    private static final int NUMBER_SIZE = 3;

    public void validate(List<Integer> numbers)
    {
        if (newHashSet(numbers).size() != NUMBER_SIZE || isNotSingle(numbers)) {
            throw new IllegalWordsException("words less than three.");
        }
    }

    private boolean isNotSingle(List<Integer> number)
    {
        boolean isSingle = from(number).allMatch(new Predicate<Integer>()
        {
            @Override
            public boolean apply(Integer number)
            {
                return Range.closed(1, 9).contains(number);
            }
        });
        return !isSingle;
    }
}
