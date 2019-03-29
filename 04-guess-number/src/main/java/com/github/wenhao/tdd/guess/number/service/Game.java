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

package com.github.wenhao.tdd.guess.number.service;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;
import com.github.wenhao.tdd.guess.number.validator.AnswerValidator;
import static com.google.common.collect.Lists.newArrayList;
import com.google.inject.Inject;

import java.util.List;

public class Game {
    private Answer answer;
    private List<GuessResult> guessResults;
    private AnswerValidator answerValidator;

    @Inject
    public Game(AnswerGenerator answerGenerator, final AnswerValidator answerValidator) {
        this.answer = answerGenerator.generate();
        this.answerValidator = answerValidator;
        this.guessResults = newArrayList();
    }

    public GuessResult guess(Answer answer) {
        answerValidator.validate(answer);
        String result = this.answer.compare(answer);
        GuessResult guessResult = createGuessResult(answer, result);
        guessResults.add(guessResult);
        return guessResult;
    }

    private GuessResult createGuessResult(Answer answer, String result) {
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer(answer.getValue());
        guessResult.setResult(result);
        return guessResult;
    }

    public List<GuessResult> getHistory() {
        return guessResults;
    }

    public String actualAnswer() {
        return answer.getValue();
    }
}
