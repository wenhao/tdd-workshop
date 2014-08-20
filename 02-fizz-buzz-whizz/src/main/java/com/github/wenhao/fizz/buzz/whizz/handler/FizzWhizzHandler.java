package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_WHIZZ;

public class FizzWhizzHandler extends BaseHandler
{
    public FizzWhizzHandler(BaseHandler baseHandler, Words words)
    {
        super(baseHandler, words);
    }

    @Override
    public String handle(Integer number)
    {
        if (isFizz(number) && isWhizz(number)) {
            return FIZZ_WHIZZ;
        }
        return getNextHandler().handle(number);
    }

    private boolean isWhizz(Integer number)
    {
        return number % getWords().getThird() == 0;
    }

    private boolean isFizz(Integer number)
    {
        return number % getWords().getFirst() == 0;
    }
}
