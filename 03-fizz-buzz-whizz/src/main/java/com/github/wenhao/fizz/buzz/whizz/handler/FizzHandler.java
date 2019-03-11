package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public class FizzHandler extends BaseHandler {
    public FizzHandler(BaseHandler baseHandler) {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number, Words words) {
        if (number % words.getFirst() == 0) {
            return FIZZ;
        }
        return getNextHandler().handle(number, words);
    }
}
