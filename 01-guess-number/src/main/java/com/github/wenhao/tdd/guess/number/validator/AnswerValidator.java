package com.github.wenhao.tdd.guess.number.validator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.exception.AnswerNumberDuplicatedException;
import com.github.wenhao.tdd.guess.number.exception.AnswerNotFourDigitException;
import com.google.inject.Inject;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

public class AnswerValidator
{

    private static final String ANSWER_REGEX = "\\d{4}";

    @Inject
    public AnswerValidator()
    {
    }

    public Boolean validate(Answer answer)
    {
        checkFourDigit(answer);
        checkDuplication(answer);
        return true;
    }

    private void checkDuplication(Answer answer)
    {
        String[] answerNumbers = answer.getValue().split(ANSWER_SEPARATOR);
        boolean isDuplicated = newHashSet(answerNumbers).size() != answerNumbers.length;
        if (isDuplicated) {
            throw new AnswerNumberDuplicatedException();
        }
    }

    private void checkFourDigit(Answer answer)
    {
        String answerWithoutSeparator = newArrayList(answer.getValue().split(ANSWER_SEPARATOR)).stream()
                .collect(Collectors.joining(""));
        boolean isMatched = Pattern.matches(ANSWER_REGEX, answerWithoutSeparator);
        if (!isMatched) {
            throw new AnswerNotFourDigitException();
        }
    }
}
