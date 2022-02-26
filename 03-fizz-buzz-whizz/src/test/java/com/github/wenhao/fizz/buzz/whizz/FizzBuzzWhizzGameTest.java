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

package com.github.wenhao.fizz.buzz.whizz;

import com.github.wenhao.fizz.buzz.whizz.domain.Student;
import com.github.wenhao.fizz.buzz.whizz.domain.Teacher;
import com.github.wenhao.fizz.buzz.whizz.factory.HandlerFactory;
import com.github.wenhao.fizz.buzz.whizz.handler.BaseHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class FizzBuzzWhizzGameTest {
    private FizzBuzzWhizzGame fizzBuzzWhizzGame;

    @Before
    public void setUp() throws Exception {
        Teacher teacher = new Teacher();
        teacher.say(3, 5, 7);

        BaseHandler handler = HandlerFactory.build();

        Student student = new Student(3, handler);

        fizzBuzzWhizzGame = new FizzBuzzWhizzGame();
        fizzBuzzWhizzGame.setTeacher(teacher);
        fizzBuzzWhizzGame.setStudents(Arrays.asList(student));
    }

    @Test
    public void should_be_able_to_count() throws Exception {
        fizzBuzzWhizzGame.countOff();
    }
}
