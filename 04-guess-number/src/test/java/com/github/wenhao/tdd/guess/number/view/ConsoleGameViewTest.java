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

package com.github.wenhao.tdd.guess.number.view;

import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class ConsoleGameViewTest {

    private ConsoleGameView consoleGameView;

    @Before
    public void setUp() throws Exception {
        consoleGameView = new ConsoleGameView();
    }

    @Test
    public void should_be_able_to_show_message() throws Exception {
        // when
        consoleGameView.showMessage("message");
    }

    @Test
    public void should_be_able_to_show_current_result() throws Exception {
        // when
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer("1 2 3 4");
        guessResult.setResult("successful");
        consoleGameView.showCurrentResult(guessResult);
    }

    @Test
    public void should_be_able_to_show_guess_results() throws Exception {
        // when
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer("1 2 3 4");
        guessResult.setResult("successful");
        consoleGameView.showGuessHistory(Arrays.asList(guessResult));
    }
}
