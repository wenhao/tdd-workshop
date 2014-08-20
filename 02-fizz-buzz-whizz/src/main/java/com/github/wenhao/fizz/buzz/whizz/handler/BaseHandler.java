package com.github.wenhao.fizz.buzz.whizz.handler;

public abstract class BaseHandler
{
    private final BaseHandler baseHandler;

    protected BaseHandler(BaseHandler baseHandler)
    {
        this.baseHandler = baseHandler;
    }

    public abstract String handle(Integer number);

    public BaseHandler getNextHandler()
    {
        return baseHandler;
    }
}
