package dao.impl;

import dao.AbstractParser;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.AbstractQuestion;
import model.impl.ClosedQuestion;
import model.impl.OpenQuestion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

@NoArgsConstructor
public class CSVParser implements AbstractParser {
    BufferedReader reader;
    @Setter
    String url;

    private void init() {
        if (reader == null) {
            try {
                reader = new BufferedReader(new FileReader(url));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public AbstractQuestion nextQuestion() {
        init();
        try {
            String[] line = reader.readLine().split(",");
            String questionText = line[0];
            String rightAnswer = line[1];
            ArrayList<String> answers = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(line, 1, line.length)));

            AbstractQuestion question;
            if (answers.size() > 1)
                question = new ClosedQuestion(questionText, rightAnswer, answers);
            else
                question = new OpenQuestion(questionText, rightAnswer);

            return question;
        } catch (Exception e) {
            return null;
        }
    }
}

