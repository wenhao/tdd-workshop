package com.github.wenhao.fizz.buzz.whizz.handler;

import com.github.wenhao.fizz.buzz.whizz.domain.Constants;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public class SpecialFizzHandler extends BaseHandler {
    public SpecialFizzHandler(BaseHandler baseHandler) {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number, Words words) {
        if (String.valueOf(number).contains(words.getFirst().toString())) {
            return Constants.FIZZ;
        }
        return getNextHandler().handle(number, words);
    }
}
