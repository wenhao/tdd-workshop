package com.github.wenhao.tdd.guess.number;

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

    public String guess(Answer answer)
    {
        String result = this.answer.compare(answer);
        add(answer, result);
        return result;
    }

    private void add(Answer answer, String result)
    {
        GuessResult guessResult = new GuessResult();
        guessResult.setInputAnswer(answer.getValue());
        guessResult.setResult(result);
        guessResults.add(guessResult);
    }

    public List<GuessResult> getHistory()
    {
        return guessResults;
    }
}
