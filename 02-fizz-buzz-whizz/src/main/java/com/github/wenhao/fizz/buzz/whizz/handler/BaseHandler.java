package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public abstract class BaseHandler
{
    private final BaseHandler baseHandler;
    private Words words;

    protected BaseHandler(BaseHandler baseHandler, Words words)
    {
        this.baseHandler = baseHandler;
        this.words = words;
    }

    public abstract String handle(Integer number);

    public BaseHandler getNextHandler()
    {
        return baseHandler;
    }

    public Words getWords()
    {
        return words;
    }
}
