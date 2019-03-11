package com.github.wenhao.fizz.buzz.whizz.handler;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_BUZZ_WHIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;

public class FizzBuzzWhizzHandler extends BaseHandler {
    public FizzBuzzWhizzHandler(BaseHandler baseHandler) {
        super(baseHandler);
    }

    @Override
    public String handle(Integer number, Words words) {
        if (isFizz(number, words) && isBuzz(number, words) && isWhizz(number, words)) {
            return FIZZ_BUZZ_WHIZZ;
        }
        return getNextHandler().handle(number, words);
    }

    private boolean isWhizz(Integer number, Words words) {
        return number % words.getThird() == 0;
    }

    private boolean isBuzz(Integer number, Words words) {
        return number % words.getSecond() == 0;
    }

    private boolean isFizz(Integer number, Words words) {
        return number % words.getFirst() == 0;
    }
}
