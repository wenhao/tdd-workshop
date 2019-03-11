package com.github.wenhao.fizz.buzz.whizz.domain;

import com.github.wenhao.fizz.buzz.whizz.validator.NumbersValidator;
import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

public class Teacher {
    private Words words;
    private NumbersValidator numbersValidator;

    public Teacher() {
        words = new Words();
        numbersValidator = new NumbersValidator();
    }

    public void say(Integer... numbers) {
        List<Integer> number = newArrayList(numbers);
        numbersValidator.validate(number);
        words.setFirst(number.get(0));
        words.setSecond(number.get(1));
        words.setThird(number.get(2));
    }

    public Words getWords() {
        return words;
    }

}

