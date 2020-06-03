package model.impl;

import lombok.AllArgsConstructor;
import model.AbstractQuestion;

@AllArgsConstructor
public class OpenQuestion implements AbstractQuestion {

    private final String question;
    private final String regexAnswer;

    @Override
    public boolean checkAnswer(String answer) {
        return answer.matches(regexAnswer);
    }

    @Override
    public String getTask() {
        return question;
    }
}
