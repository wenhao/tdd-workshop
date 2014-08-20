package com.github.wenhao.fizz.buzz.whizz.factory;

import com.github.wenhao.fizz.buzz.whizz.domain.Words;
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

public final class HandlerFactory
{
    private HandlerFactory()
    {
    }

    public static BaseHandler build(Words words)
    {
        DefaultHandler defaultHandler = new DefaultHandler();
        WhizzHandler whizzHandler = new WhizzHandler(defaultHandler, words);
        BuzzHandler buzzHandler = new BuzzHandler(whizzHandler, words);
        FizzHandler fizzHandler = new FizzHandler(buzzHandler, words);
        BuzzWhizzHandler buzzWhizzHandler = new BuzzWhizzHandler(fizzHandler, words);
        FizzWhizzHandler fizzWhizzHandler = new FizzWhizzHandler(buzzWhizzHandler, words);
        FizzBuzzHandler fizzBuzzHandler = new FizzBuzzHandler(fizzWhizzHandler, words);
        FizzBuzzWhizzHandler fizzBuzzWhizzHandler = new FizzBuzzWhizzHandler(fizzBuzzHandler, words);
        return new SpecialFizzHandler(fizzBuzzWhizzHandler, words);
    }
}
