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

import com.github.wenhao.fizz.buzz.whizz.exception.IllegalWordsException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class TeacherTest {

    private Teacher teacher;

    @Before
    public void setUp() {
        teacher = new Teacher();
    }

    @Test
    public void should_raise_exception_when_less_than_three_numbers() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 2));
    }

    @Test
    public void should_raise_exception_when_greater_than_three_numbers() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 2, 3, 4));
    }

    @Test
    public void should_raise_exception_when_has_same_number() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 1, 2));
    }

    @Test
    public void should_raise_exception_when_number_bigger_than_ten() throws Exception {
        // when
        assertThrows(IllegalWordsException.class, () -> teacher.say(1, 11, 12));
    }
}
