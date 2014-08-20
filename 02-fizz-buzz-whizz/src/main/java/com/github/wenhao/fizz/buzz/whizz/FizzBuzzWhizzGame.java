package com.github.wenhao.fizz.buzz.whizz;

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

public class FizzBuzzWhizzGame
{

    private BaseHandler baseHandler;

    public FizzBuzzWhizzGame()
    {
        this.baseHandler = new SpecialFizzHandler(new FizzBuzzWhizzHandler(new FizzBuzzHandler(
                new FizzWhizzHandler(new BuzzWhizzHandler(((new FizzHandler(new BuzzHandler(new WhizzHandler(new DefaultHandler()))))))))));
    }

    public String countOff(Integer number)
    {
        return baseHandler.handle(number);
    }


}

