package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ;

public class FizzBuzzHandler extends BaseHandler
{
    public FizzBuzzHandler(BaseHandler baseHandler, Words words)
    {
        super(baseHandler, words);
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
        return number % getWords().getSecond() == 0;
    }

    private boolean isFizz(Integer number)
    {
        return number % getWords().getFirst() == 0;
    }
}
