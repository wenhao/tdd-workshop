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

import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.FIZZ;
import static com.github.wenhao.fizz.buzz.whizz.domain.Constants.WHIZZ;
import com.github.wenhao.fizz.buzz.whizz.domain.Words;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WhizzHandlerTest {

    private WhizzHandler whizzHandler;
    private Words words;

    @BeforeEach
    public void setUp() throws Exception {
        words = mock(Words.class);
        when(words.getFirst()).thenReturn(3);
        when(words.getSecond()).thenReturn(5);
        when(words.getThird()).thenReturn(7);
        whizzHandler = new WhizzHandler(new FizzHandler(null));
    }

    @Test
    public void should_be_able_to_return_Whizz_when_student_count_is_multiple_of_7() throws Exception {
        // when
        String result = whizzHandler.handle(7, words);

        // then
        assertThat(result).isEqualTo(WHIZZ);
    }

    @Test
    public void should_next_handler_process() throws Exception {
        // when
        String result = whizzHandler.handle(3, words);

        // then
        assertThat(result).isEqualTo(FIZZ);
    }

}