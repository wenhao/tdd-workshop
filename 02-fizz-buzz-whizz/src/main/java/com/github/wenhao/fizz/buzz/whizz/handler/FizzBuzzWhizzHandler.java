package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ_WHIZZ;

public class FizzBuzzWhizzHandler extends BaseHandler
{
    public FizzBuzzWhizzHandler(BaseHandler baseHandler, Words words)
    {
        super(baseHandler, words);
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
        return number % getWords().getThird() == 0;
    }

    private boolean isBuzz(Integer number)
    {
        return number % getWords().getSecond() == 0;
    }

    private boolean isFizz(Integer number)
    {
        return number % getWords().getFirst() == 0;
    }
}
