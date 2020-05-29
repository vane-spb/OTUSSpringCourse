package Parsers;

import Quiz.AbstractQuestion;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class CSVParser implements AbstractParser{
    @Setter
    private String url;
    @Override
    public HashSet<AbstractQuestion> questions() {
        return null;
    }
}
