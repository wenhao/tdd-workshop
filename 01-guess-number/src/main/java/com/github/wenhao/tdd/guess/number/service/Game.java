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
