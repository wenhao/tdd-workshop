/*
 * Copyright © 2019, Wen Hao <wenhao@126.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
