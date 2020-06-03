package service;

import dao.AbstractParser;
import model.AbstractQuestion;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Quiz {
    int score, totalQuestions;
    AbstractParser parser;
    Scanner input;

    public Quiz() {
        score = 0;
        totalQuestions = 0;
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/Spring/spring.xml");
        parser = (AbstractParser) context.getBean("CSVParser");
        input = new Scanner(System.in);

        AbstractQuestion question;
        while ((question = parser.nextQuestion()) != null) {
            ask(question);
            reserveAnswer(question);
        }

        printSummary();

    }

    private void printSummary() {
        System.out.println("\n ---------------------------------");
        System.out.println("Congratulations! Your score is " + score + "/" + totalQuestions);
    }

    private void ask(AbstractQuestion question) {
        System.out.println(question.getTask());
        totalQuestions++;
    }

    private void reserveAnswer(AbstractQuestion question) {
        String usersAnswer = input.nextLine();
        if (question.checkAnswer(usersAnswer)) {
            score++;
        }
    }
}
