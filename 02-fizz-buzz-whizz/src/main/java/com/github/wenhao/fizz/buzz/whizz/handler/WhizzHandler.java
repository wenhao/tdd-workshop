package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;

public class WhizzHandler extends BaseHandler
{
    public WhizzHandler(BaseHandler baseHandler, Words words)
    {
        super(baseHandler, words);
    }

    @Override
    public String handle(Integer number)
    {
        if (number % getWords().getThird() == 0) {
            return WHIZZ;
        }
        return getNextHandler().handle(number);
    }
}
