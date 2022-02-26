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

package com.github.wenhao.tdd.guess.number.validator;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.exception.AnswerNotFourDigitException;
import com.github.wenhao.tdd.guess.number.exception.AnswerNumberDuplicatedException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class AnswerValidatorTest {

    private AnswerValidator answerValidator;

    @Before
    public void setUp() {
        answerValidator = new AnswerValidator();
    }

    @Test
    public void should_raise_error_out_of_range_answer_exception_which_is_not_between_0_and_9() throws Exception {
        // given
        Answer answer = Answer.createAnswer("1 2 3 11");

        // when
        assertThrows(AnswerNotFourDigitException.class, () -> answerValidator.validate(answer));
    }

    @Test
    public void should_raise_error_which_size_is_not_4() throws Exception {
        // given
        Answer answer = Answer.createAnswer("1 2");

        // when
        assertThrows(AnswerNotFourDigitException.class, () -> answerValidator.validate(answer));
    }

    @Test
    public void should_raise_error_which_contains_duplication() throws Exception {
        // given
        Answer answer = Answer.createAnswer("1 2 2 3");

        // when
        assertThrows(AnswerNumberDuplicatedException.class, () -> answerValidator.validate(answer));
    }
}
