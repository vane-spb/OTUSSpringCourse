package model;

public interface AbstractQuestion {
    boolean checkAnswer(String answer);
    String getTask();
}
