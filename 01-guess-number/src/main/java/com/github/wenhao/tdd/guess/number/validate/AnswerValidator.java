package com.github.wenhao.tdd.guess.number.validate;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.exception.AnswerLengthInvalidException;
import com.github.wenhao.tdd.guess.number.exception.AnswerOutOfRangeException;
import com.google.common.base.Predicate;

import java.util.List;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_RANGE;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SIZE;
import static com.google.common.collect.Iterators.all;
import static com.google.common.collect.Lists.newArrayList;

public class AnswerValidator
{
    public Boolean validate(Answer answer)
    {
        List<String> numbers = newArrayList(answer.getValue().split(ANSWER_SEPARATOR));
        checkRange(numbers);
        checkLength(numbers);
        return true;
    }

    private void checkLength(List<String> numbers)
    {
        if (numbers.size() != ANSWER_SIZE) {
            throw new AnswerLengthInvalidException();
        }
    }

    private void checkRange(List<String> numbers)
    {
        boolean isBetween0And9 = all(numbers.iterator(), new Predicate<String>()
        {
            @Override
            public boolean apply(String number)
            {
                return ANSWER_RANGE.contains(Integer.valueOf(number));
            }
        });
        if (!isBetween0And9) {
            throw new AnswerOutOfRangeException();
        }
    }
}
