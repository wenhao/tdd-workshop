package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ;

public class FizzBuzzHandler extends BaseHandler
{
    public FizzBuzzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number, Words words)
    {
        if (isFizz(number, words) && isBuzz(number, words)) {
            return FIZZ_BUZZ;
        }
        return getNextHandler().handle(number, words);
    }

    private boolean isBuzz(Integer number, Words words)
    {
        return number % words.getSecond() == 0;
    }

    private boolean isFizz(Integer number, Words words)
    {
        return number % words.getFirst() == 0;
    }
}
