package Quiz;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.HashSet;

public class ClosedQuestion implements AbstractQuestion{

    String question;
    HashSet<String> variants;
    String trueVariant;

    public boolean checkAnswer(String answer) {
        return answer.equals(this.trueVariant);
    }

    public String getTask() {
        final StringStack task = new StringStack();
        task.add(question);
        task.add("\n\n");
        variants.forEach(v -> {task.add(v); task.add("\n");});

        return task.peekString();
    }
}
