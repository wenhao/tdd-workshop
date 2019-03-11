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
