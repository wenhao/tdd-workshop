package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ_WHIZZ;

public class FizzBuzzWhizzHandler extends BaseHandler
{
    public FizzBuzzWhizzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number)
    {
        if (isFizz(number) && isBuzz(number) && isWhizz(number)) {
            return FIZZ_BUZZ_WHIZZ;
        }
        return getNextHandler().handle(number);
    }

    private boolean isWhizz(Integer number)
    {
        return number % 7 == 0;
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
