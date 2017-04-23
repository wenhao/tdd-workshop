package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_WHIZZ;

public class FizzWhizzHandler extends BaseHandler
{
    public FizzWhizzHandler(BaseHandler baseHandler)
    {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number, Words words)
    {
        if (isFizz(number, words) && isWhizz(number, words)) {
            return FIZZ_WHIZZ;
        }
        return getNextHandler().handle(number, words);
    }

    private boolean isWhizz(Integer number, Words words)
    {
        return number % words.getThird() == 0;
    }

    private boolean isFizz(Integer number, Words words)
    {
        return number % words.getFirst() == 0;
    }
}
