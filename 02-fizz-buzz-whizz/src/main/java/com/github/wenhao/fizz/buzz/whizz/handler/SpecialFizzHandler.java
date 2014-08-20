package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Constants;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public class SpecialFizzHandler extends BaseHandler
{
    public SpecialFizzHandler(BaseHandler baseHandler, Words words)
    {
        super(baseHandler, words);
    }

    @Override
    public String handle(Integer number)
    {
        if (String.valueOf(number).contains(getWords().getFirst().toString())) {
            return Constants.FIZZ;
        }
        return getNextHandler().handle(number);
    }
}
