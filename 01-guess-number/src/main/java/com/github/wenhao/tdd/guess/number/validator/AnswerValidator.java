package com.github.wenhao.tdd.guess.number.validator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.exception.AnswerNotFourDigitException;
import com.github.wenhao.tdd.guess.number.exception.AnswerNumberDuplicatedException;
import com.google.inject.Inject;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.regex.Pattern.matches;

public class AnswerValidator
{

    private static final String ANSWER_REGEX = "^\\d{4}$";

    @Inject
    public AnswerValidator()
    {
    }

    public void validate(final Answer answer)
    {
        String[] answerNumbers = answer.getValue().split(ANSWER_SEPARATOR);
        checkDuplicate(answerNumbers);
        checkWhetherFourDigit(answerNumbers);
    }

    private void checkWhetherFourDigit(final String[] answerNumbers)
    {
        String answerString = Arrays.stream(answerNumbers).collect(Collectors.joining(""));
        boolean isFourDigit = matches(ANSWER_REGEX, answerString);
        if (!isFourDigit) {
            throw new AnswerNotFourDigitException();
        }
    }

    private void checkDuplicate(final String[] answerNumbers)
    {
        boolean isContainsDuplication = newHashSet(answerNumbers).size() != answerNumbers.length;
        if (isContainsDuplication) {
            throw new AnswerNumberDuplicatedException();
        }
    }
}
