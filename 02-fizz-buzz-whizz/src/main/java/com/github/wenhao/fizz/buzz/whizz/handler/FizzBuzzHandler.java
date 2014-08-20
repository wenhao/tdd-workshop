package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ;

public class FizzBuzzHandler extends BaseHandler
{
    public FizzBuzzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number)
    {
        if (isFizz(number) && isBuzz(number)) {
            return FIZZ_BUZZ;
        }
        return getNextHandler().handle(number);
    }

    private boolean isBuzz(Integer number)
    {
        return number % 5 == 0;
    }

    private boolean isFizz(Integer number)
    {
        return number % 3 == 0;
    }
}
