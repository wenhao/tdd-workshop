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

