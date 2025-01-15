package jonas.exambyte.application;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class QuizSession {
    QuizDto quizDto = new QuizDto();

    public QuizDto getQuizdto() {
        return quizDto;
    }
    public QuizDto clear(){
        return new QuizDto();
    }
}
