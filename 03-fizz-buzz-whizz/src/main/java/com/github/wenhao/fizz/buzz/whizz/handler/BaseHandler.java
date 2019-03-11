package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public abstract class BaseHandler {
    private final BaseHandler baseHandler;

    protected BaseHandler(BaseHandler baseHandler) {
        this.baseHandler = baseHandler;
    }

    public abstract String handle(Integer number, Words words);

    public BaseHandler getNextHandler() {
        return baseHandler;
    }
}
