package com.github.wenhao.tdd.guess.number.exception;

public class OutOfRangeAnswerException extends RuntimeException
{
    public OutOfRangeAnswerException()
    {
        super();
    }

    public OutOfRangeAnswerException(String message)
    {
        super(message);
    }
}
