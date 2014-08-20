package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;

public class BuzzHandler extends BaseHandler
{
    public BuzzHandler(BaseHandler baseHandler, Words words)
    {
        super(baseHandler, words);
    }

    @Override
    public String handle(Integer number)
    {
        if (number % getWords().getSecond() == 0) {
            return BUZZ;
        }
        return getNextHandler().handle(number);
    }
}
