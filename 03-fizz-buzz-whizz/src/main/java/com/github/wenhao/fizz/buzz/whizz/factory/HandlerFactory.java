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

package com.github.wenhao.fizz.buzz.whizz.factory;

import com.github.wenhao.fizz.buzz.whizz.handler.BaseHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.BuzzHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.BuzzWhizzHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.DefaultHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.FizzBuzzHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.FizzBuzzWhizzHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.FizzHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.FizzWhizzHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.SpecialFizzHandler;
import com.github.wenhao.fizz.buzz.whizz.handler.WhizzHandler;

public final class HandlerFactory {
    private HandlerFactory() {
    }

    public static BaseHandler build() {
        DefaultHandler defaultHandler = new DefaultHandler();
        WhizzHandler whizzHandler = new WhizzHandler(defaultHandler);
        BuzzHandler buzzHandler = new BuzzHandler(whizzHandler);
        FizzHandler fizzHandler = new FizzHandler(buzzHandler);
        BuzzWhizzHandler buzzWhizzHandler = new BuzzWhizzHandler(fizzHandler);
        FizzWhizzHandler fizzWhizzHandler = new FizzWhizzHandler(buzzWhizzHandler);
        FizzBuzzHandler fizzBuzzHandler = new FizzBuzzHandler(fizzWhizzHandler);
        FizzBuzzWhizzHandler fizzBuzzWhizzHandler = new FizzBuzzWhizzHandler(fizzBuzzHandler);
        return new SpecialFizzHandler(fizzBuzzWhizzHandler);
    }
}
