package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;

public class BuzzHandler extends BaseHandler
{
    public BuzzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number)
    {
        if (number % 5 == 0) {
            return BUZZ;
        }
        return getNextHandler().handle(number);
    }
}
