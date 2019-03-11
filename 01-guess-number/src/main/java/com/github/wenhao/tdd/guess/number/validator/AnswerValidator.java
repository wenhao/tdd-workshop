package com.github.wenhao.tdd.guess.number.validator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import com.github.wenhao.tdd.guess.number.exception.AnswerNotFourDigitException;
import com.github.wenhao.tdd.guess.number.exception.AnswerNumberDuplicatedException;
import static com.google.common.collect.Sets.newHashSet;
import com.google.inject.Inject;
import static java.util.regex.Pattern.matches;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AnswerValidator {

    private static final String ANSWER_REGEX = "^\\d{4}$";

    @Inject
    public AnswerValidator() {
    }

    public void validate(final Answer answer) {
        String[] answerNumbers = answer.getValue().split(ANSWER_SEPARATOR);
        checkDuplicate(answerNumbers);
        checkWhetherFourDigit(answerNumbers);
    }

    private void checkWhetherFourDigit(final String[] answerNumbers) {
        String answerString = Arrays.stream(answerNumbers).collect(Collectors.joining(""));
        boolean isFourDigit = matches(ANSWER_REGEX, answerString);
        if (!isFourDigit) {
            throw new AnswerNotFourDigitException();
        }
    }

    private void checkDuplicate(final String[] answerNumbers) {
        boolean isContainsDuplication = newHashSet(answerNumbers).size() != answerNumbers.length;
        if (isContainsDuplication) {
            throw new AnswerNumberDuplicatedException();
        }
    }
}
