package com.github.wenhao.fizz.buzz.whizz;

import com.github.wenhao.fizz.buzz.whizz.domain.Teacher;
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
    private Teacher teacher;

    public FizzBuzzWhizzGame(Teacher teacher)
    {
        this.teacher = teacher;
        DefaultHandler defaultHandler = new DefaultHandler();
        WhizzHandler whizzHandler = new WhizzHandler(defaultHandler, this.teacher.getWords());
        BuzzHandler buzzHandler = new BuzzHandler(whizzHandler, this.teacher.getWords());
        FizzHandler fizzHandler = new FizzHandler(buzzHandler, this.teacher.getWords());
        BuzzWhizzHandler buzzWhizzHandler = new BuzzWhizzHandler(fizzHandler, this.teacher.getWords());
        FizzWhizzHandler fizzWhizzHandler = new FizzWhizzHandler(buzzWhizzHandler, this.teacher.getWords());
        FizzBuzzHandler fizzBuzzHandler = new FizzBuzzHandler(fizzWhizzHandler, this.teacher.getWords());
        FizzBuzzWhizzHandler fizzBuzzWhizzHandler = new FizzBuzzWhizzHandler(fizzBuzzHandler, this.teacher.getWords());
        this.baseHandler = new SpecialFizzHandler(fizzBuzzWhizzHandler, this.teacher.getWords());
    }

    public String countOff(Integer number)
    {
        return baseHandler.handle(number);
    }

}

