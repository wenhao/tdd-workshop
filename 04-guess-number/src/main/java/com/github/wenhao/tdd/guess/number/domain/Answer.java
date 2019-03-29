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

package com.github.wenhao.tdd.guess.number.domain;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;
import java.util.function.Predicate;

public class Answer {
    public static final String ANSWER_TEMPLATE = "%sA%sB";
    private String value;

    public Answer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Answer createAnswer(String value) {
        return new Answer(value);
    }

    public String compare(final Answer answer) {
        return String.format(ANSWER_TEMPLATE, countBy(correctNumberAndPosition(answer.getValue())),
                countBy(correctNumberButWrongPosition(answer.getValue())));
    }

    private Long countBy(Predicate<String> predicate) {
        return getAnswerNumbers(this.value).stream()
                .filter(predicate)
                .count();
    }

    private Predicate<String> correctNumberAndPosition(final String inputAnswer) {
        return number -> isContains(inputAnswer, number) && isSamePosition(inputAnswer, number);
    }

    private Predicate<String> correctNumberButWrongPosition(final String inputAnswer) {
        return number -> isContains(inputAnswer, number) && !isSamePosition(inputAnswer, number);
    }

    private boolean isContains(final String inputAnswer, final String number) {
        return getAnswerNumbers(inputAnswer).contains(number);
    }

    private boolean isSamePosition(final String inputAnswer, final String number) {
        return getAnswerNumbers(this.value).indexOf(number) ==
                getAnswerNumbers(inputAnswer).indexOf(number);
    }

    private List<String> getAnswerNumbers(String value) {
        return newArrayList(value.split(ANSWER_SEPARATOR));
    }

}
