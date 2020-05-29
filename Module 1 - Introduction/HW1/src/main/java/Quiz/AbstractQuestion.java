package Quiz;

public interface AbstractQuestion {
    boolean checkAnswer(String answer);
    String getTask();
}
