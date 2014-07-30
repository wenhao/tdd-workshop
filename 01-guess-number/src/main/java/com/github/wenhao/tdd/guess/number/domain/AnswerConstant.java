package com.github.wenhao.tdd.guess.number.domain;

import com.google.common.collect.Range;

public final class AnswerConstant
{
    public static final Integer ANSWER_SIZE = 4;
    public static final String ANSWER_SEPARATOR = " ";
    public static final Range<Integer> ANSWER_RANGE = Range.closed(0, 9);
    public static final String CORRECT_ANSWER = "4A0B";
    public static final Integer MAX_TIMES = 6;

    private AnswerConstant()
    {
    }
}
