package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public class WhizzHandler extends BaseHandler {
    public WhizzHandler(BaseHandler baseHandler) {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number, Words words) {
        if (number % words.getThird() == 0) {
            return WHIZZ;
        }
        return getNextHandler().handle(number, words);
    }
}
