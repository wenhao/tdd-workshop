package com.github.wenhao.tdd.guess.number.service;

import com.github.wenhao.tdd.guess.number.domain.Answer;
import com.github.wenhao.tdd.guess.number.domain.GuessResult;
import com.github.wenhao.tdd.guess.number.generator.AnswerGenerator;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Game
{
    private Answer answer;
    private AnswerGenerator answerGenerator;
    private List<GuessResult> guessResults;

    public Game(AnswerGenerator answerGenerator)
    {
        this.answerGenerator = answerGenerator;
        this.answer = answerGenerator.generate();
        this.guessResults = newArrayList();
    }

    public GuessResult guess(Answer answer)
    {
        String result = this.answer.compare(answer);
        GuessResult guessResult = createGuessResult(answer, result);
        guessResults.add(guessResult);
        return guessResult;
    }

    private GuessResult createGuessResult(Answer answer, String result)
    {
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer(answer.getValue());
        guessResult.setResult(result);
        return guessResult;
    }

    public List<GuessResult> getHistory()
    {
        return guessResults;
    }

    public String actualAnswer()
    {
        return answer.getValue();
    }
}
