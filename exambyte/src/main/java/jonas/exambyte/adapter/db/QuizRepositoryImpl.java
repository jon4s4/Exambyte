package jonas.exambyte.adapter.db;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jonas.exambyte.domain.model.Aufgabe;
import jonas.exambyte.domain.model.Quiz;
import jonas.exambyte.domain.service.QuizRepository;

@Repository
public class QuizRepositoryImpl implements QuizRepository {

  SpringDataExambyteRepository springDataExambyteRepository;

  public QuizRepositoryImpl(SpringDataExambyteRepository springDataExambyteRepository) {
    this.springDataExambyteRepository = springDataExambyteRepository;
  }

  @Override
  public List<Quiz> findAll() {
    List<jonas.exambyte.adapter.db.Quiz> quizze = springDataExambyteRepository.findAll();
    return quizze.stream().map(this::convertQuiz).toList();
  }

  @Override
  public Optional<Quiz> findById(long id) {
    jonas.exambyte.adapter.db.Quiz quizDB = springDataExambyteRepository.findById(id);
    return Optional.of(convertQuiz(quizDB));
  }

  @Override
  public Quiz save(Quiz requestedQuiz) {
    List<jonas.exambyte.adapter.db.Aufgabe> aufgaben = requestedQuiz.getAlleAufgaben().stream().map(this::extractAufgaben).toList();
    jonas.exambyte.adapter.db.Quiz quizDB1 = new jonas.exambyte.adapter.db.Quiz(requestedQuiz.getId(), aufgaben,
            requestedQuiz.getStartTime(), requestedQuiz.getEndTime());
    jonas.exambyte.adapter.db.Quiz saved = springDataExambyteRepository.save(quizDB1);
    return convertQuiz(saved);
  }

  private Quiz convertQuiz(jonas.exambyte.adapter.db.Quiz quiz1DB) {
    Quiz result = new Quiz(quiz1DB.id(), quiz1DB.startTime(), quiz1DB.endTime());
    quiz1DB.aufgaben().forEach(a -> result.addAufgabe(convertAufgabe(a)));
    
    return result;
  }

  private Aufgabe convertAufgabe(jonas.exambyte.adapter.db.Aufgabe a) {
    Aufgabe aufgabe = new Aufgabe(a.frage(), a.aufgabentyp());
    
    return aufgabe;
  }

  private jonas.exambyte.adapter.db.Aufgabe extractAufgaben(Aufgabe aufgabe) {
    return new jonas.exambyte.adapter.db.Aufgabe(aufgabe.frage(), aufgabe.aufgabentyp());
  }

  @Override
  public void deleteQuizById(long id) {
    springDataExambyteRepository.deleteById(id);
  }
  
}
