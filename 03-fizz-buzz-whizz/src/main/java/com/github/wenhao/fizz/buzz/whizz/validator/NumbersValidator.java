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

package com.github.wenhao.fizz.buzz.whizz.validator;

import com.github.wenhao.fizz.buzz.whizz.exception.IllegalWordsException;
import com.google.common.collect.Range;
import static com.google.common.collect.Sets.newHashSet;

import java.util.List;

public class NumbersValidator {
    private static final int NUMBER_SIZE = 3;

    public void validate(List<Integer> numbers) {
        if (newHashSet(numbers).size() != NUMBER_SIZE || isNotSingle(numbers)) {
            throw new IllegalWordsException("words less than three.");
        }
    }

    private boolean isNotSingle(List<Integer> number) {
        boolean isSingle = number.stream().allMatch(number1 -> Range.closed(1, 9).contains(number1));
        return !isSingle;
    }
}
