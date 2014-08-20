package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ_WHIZZ;

public class BuzzWhizzHandler extends BaseHandler
{
    public BuzzWhizzHandler(BaseHandler baseHandler, Words words)
    {
        super(baseHandler, words);
    }

    @Override
    public String handle(Integer number)
    {
        if (isBuzz(number) && isWhizz(number)) {
            return BUZZ_WHIZZ;
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
}
