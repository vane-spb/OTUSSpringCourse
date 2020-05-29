package Parsers;

import Quiz.AbstractQuestion;

import java.util.HashSet;

public interface AbstractParser {
    HashSet<AbstractQuestion> questions();
}
