package model.impl;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.AbstractQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Setter
@Getter
public class ClosedQuestion implements AbstractQuestion {
    private final String question;
    private final ArrayList<String> variants;
    private final String trueVariant;

    public ClosedQuestion(String questionText, String rightAnswer, ArrayList<String> answers) {
        this.question = questionText;
        this.trueVariant = rightAnswer;
        Collections.shuffle(answers);
        this.variants = answers;
    }

    public boolean checkAnswer(String answer) {
        if (answer.equals(this.trueVariant))
            return true;
        int ans = Integer.parseInt(answer);
        if (ans >= 0 && ans < this.variants.size()) {
            return variants.get(ans).equals(this.trueVariant);
        }
        return false;
    }

    public String getTask() {
        final StringJoiner task = new StringJoiner("");
        task.add(question);
        task.add("\n\n");
        AtomicInteger iterator = new AtomicInteger();
        variants.forEach(v -> {
            task.add(iterator.get() + "");
            task.add(") ");
            task.add(v);
            task.add("\n");
            iterator.getAndIncrement();
        });

        return task.toString();
    }
}
