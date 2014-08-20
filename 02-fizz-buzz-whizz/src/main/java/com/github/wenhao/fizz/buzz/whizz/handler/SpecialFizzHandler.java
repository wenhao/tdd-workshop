package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Constants;

public class SpecialFizzHandler extends BaseHandler
{
    public SpecialFizzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number)
    {
        if (String.valueOf(number).contains("3")) {
            return Constants.FIZZ;
        }
        return getNextHandler().handle(number);
    }
}
