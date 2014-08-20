package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;

public class WhizzHandler extends BaseHandler
{
    public WhizzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number)
    {
        if (number % 7 == 0) {
            return WHIZZ;
        }
        return getNextHandler().handle(number);
    }
}
