package com.github.wenhao.tdd.guess.number.domain;

import java.util.List;
import java.util.function.Predicate;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.ANSWER_SEPARATOR;
import static com.google.common.collect.Lists.newArrayList;

public class Answer
{
    public static final String ANSWER_TEMPLATE = "%sA%sB";
    private String value;

    public Answer(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public static Answer createAnswer(String value)
    {
        return new Answer(value);
    }

    public String compare(final Answer answer)
    {
        return String.format(ANSWER_TEMPLATE, countBy(correctNumberAndPosition(answer.getValue())),
                countBy(correctNumberButWrongPosition(answer.getValue())));
    }

    private Long countBy(Predicate<String> predicate)
    {
        return getAnswerNumbers(this.value).stream()
                .filter(predicate)
                .count();
    }

    private Predicate<String> correctNumberAndPosition(final String inputAnswer)
    {
        return number -> isContains(inputAnswer, number) && isSamePosition(inputAnswer, number);
    }

    private Predicate<String> correctNumberButWrongPosition(final String inputAnswer)
    {
        return number -> isContains(inputAnswer, number) && !isSamePosition(inputAnswer, number);
    }

    private boolean isContains(final String inputAnswer, final String number)
    {
        return getAnswerNumbers(inputAnswer).contains(number);
    }

    private boolean isSamePosition(final String inputAnswer, final String number)
    {
        return getAnswerNumbers(this.value).indexOf(number) ==
                getAnswerNumbers(inputAnswer).indexOf(number);
    }

    private List<String> getAnswerNumbers(String value)
    {
        return newArrayList(value.split(ANSWER_SEPARATOR));
    }

}
