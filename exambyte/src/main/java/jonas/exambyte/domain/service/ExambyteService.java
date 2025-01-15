package jonas.exambyte.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jonas.exambyte.application.QuizDto;
import jonas.exambyte.domain.model.Aufgabe;
import jonas.exambyte.domain.model.Aufgabentyp;
import jonas.exambyte.domain.model.Quiz;

@Service
public class ExambyteService{
    QuizRepository quizRepository;

    public ExambyteService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> alleQuizze(){

        return quizRepository.findAll();
    }

    public Quiz findQuizById(long id){
        return quizRepository.findById(id)
        .orElseThrow(NichtVorhandenException::new);
    }

    public Quiz aufgabeHinzufügen(long id, String frage, Aufgabentyp aufgabentyp){
        if (frage == null || frage.isEmpty()) {
            throw new UngueltigeEingabeException();
        }
        Quiz requestedQuiz = findQuizById(id);
        requestedQuiz.addAufgabe(new Aufgabe(frage, aufgabentyp));
        return quizRepository.save(requestedQuiz);
    }

    public long quizHinzufuegen(){
        Quiz newQuiz = new Quiz();
        Quiz savedQuiz = quizRepository.save(newQuiz);

        return savedQuiz.getId();
    }
    public void deleteQuizById(long id){
        deleteAllAufgaben(id);
        quizRepository.deleteQuizById(id);
    }
    public void deleteAllAufgaben(long id){
        Quiz quiz = quizRepository.findById(id).orElseThrow(NichtVorhandenException::new);
        quiz.getAlleAufgaben().clear();
        quizRepository.save(quiz);
    }

    public void saveQuiz(QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setStartTime(quizDto.getStartTime());
        quiz.setEndTime(quizDto.getEndTime());
        List<Aufgabe> aufgaben = quizDto.getAufgaben()
        .stream().map(a -> new Aufgabe(a.frage(), a.aufgabentyp()))
        .toList();
        quiz.setAlleAufgabe(aufgaben);
        quizRepository.save(quiz);
    }
}
