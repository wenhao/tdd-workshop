package com.github.wenhao.tdd.guess.number.domain;

import static com.github.wenhao.tdd.guess.number.domain.AnswerConstant.CORRECT_ANSWER;

public class GuessResult {
    private String result;
    private String inputAnswer;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getInputAnswer() {
        return inputAnswer;
    }

    public void setInputAnswer(String inputAnswer) {
        this.inputAnswer = inputAnswer;
    }

    public Boolean correct() {
        return result.equals(CORRECT_ANSWER);
    }
}
