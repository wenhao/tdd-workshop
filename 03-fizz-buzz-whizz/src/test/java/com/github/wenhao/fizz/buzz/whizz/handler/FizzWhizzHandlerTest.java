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

import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import org.junit.Before;
import org.junit.Test;

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.BUZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ_WHIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FizzWhizzHandlerTest {

    private FizzWhizzHandler fizzWhizzHandler;
    private Words words;

    @Before
    public void setUp() throws Exception {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        fizzWhizzHandler = new FizzWhizzHandler(new FizzHandler(new BuzzHandler(new WhizzHandler(null))));
    }

    @Test
    public void should_be_able_to_return_fizz_whizz_when_student_count_is_multiple_of_3_and_7() throws Exception {
        // when
        String result = fizzWhizzHandler.handle(21, words);

        // then
        assertThat(result).isEqualTo(FIZZ_WHIZZ);
    }

    @Test
    public void should_next_handler_process() throws Exception {
        // when
        String fizz = fizzWhizzHandler.handle(3, words);
        String buzz = fizzWhizzHandler.handle(5, words);
        String whizz = fizzWhizzHandler.handle(7, words);

        // then
        assertThat(fizz).isEqualTo(FIZZ);
        assertThat(buzz).isEqualTo(BUZZ);
        assertThat(whizz).isEqualTo(WHIZZ);
    }
}
