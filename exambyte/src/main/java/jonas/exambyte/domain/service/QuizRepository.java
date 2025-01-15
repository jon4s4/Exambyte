package jonas.exambyte.domain.service;

import java.util.List;
import java.util.Optional;

import jonas.exambyte.domain.model.Quiz;

public interface QuizRepository{
    List<Quiz> findAll();

    Optional<Quiz> findById(long id);

    Quiz save(Quiz requestedQuiz);

    void deleteQuizById(long id);
}
