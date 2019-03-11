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

package com.github.wenhao.tdd.guess.number.config;

import com.github.wenhao.tdd.guess.number.command.ConsoleInputCommand;
import com.github.wenhao.tdd.guess.number.command.InputCommand;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import com.github.wenhao.tdd.guess.number.generator.RandomIntGenerator;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import com.github.wenhao.tdd.guess.number.view.ConsoleGameView;
import com.github.wenhao.tdd.guess.number.view.GameView;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import static java.nio.charset.Charset.forName;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class GameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(InputCommand.class).to(ConsoleInputCommand.class).in(Singleton.class);
        bind(GameView.class).to(ConsoleGameView.class).in(Singleton.class);
        bind(AnswerGenerator.class).in(Singleton.class);
        bind(RandomIntGenerator.class).in(Singleton.class);
        bind(Random.class).in(Singleton.class);
        bind(AnswerValidator.class).in(Singleton.class);
    }

    @Provides
    BufferedReader provideBufferedReader() {
        return new BufferedReader(new InputStreamReader(System.in, forName("UTF-8")));
    }
}
