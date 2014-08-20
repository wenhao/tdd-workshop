package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;

public class FizzHandler extends BaseHandler
{
    public FizzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number)
    {
        if (number % 3 == 0) {
            return FIZZ;
        }
        return getNextHandler().handle(number);
    }
}