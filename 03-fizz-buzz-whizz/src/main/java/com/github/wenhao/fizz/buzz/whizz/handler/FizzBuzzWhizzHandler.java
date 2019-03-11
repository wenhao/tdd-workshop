/*
 * Copyright © 2019, Wen Hao <wenhao@126.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
