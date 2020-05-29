package Quiz;

public class OpenQuestion implements AbstractQuestion{

    String question;
    String regexAnswer;

    @Override
    public boolean checkAnswer(String answer) {
        return answer.matches(regexAnswer);
    }

    @Override
    public String getTask() {
        return question;
    }
}
