package com.github.wenhao.fizz.buzz.whizz.validator;

import com.github.wenhao.fizz.buzz.whizz.exception.IllegalWordsException;
import com.google.common.collect.Range;
import static com.google.common.collect.Sets.newHashSet;

import java.util.List;

public class NumbersValidator {
    private static final int NUMBER_SIZE = 3;

    public void validate(List<Integer> numbers) {
        if (newHashSet(numbers).size() != NUMBER_SIZE || isNotSingle(numbers)) {
            throw new IllegalWordsException("words less than three.");
        }
    }

    private boolean isNotSingle(List<Integer> number) {
        boolean isSingle = number.stream().allMatch(number1 -> Range.closed(1, 9).contains(number1));
        return !isSingle;
    }
}
