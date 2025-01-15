package jonas.exambyte.adapter.controller;

import jonas.exambyte.application.AufgabeDto;
import jonas.exambyte.application.QuizDto;
import jonas.exambyte.application.QuizSession;
import jonas.exambyte.domain.model.Aufgabe;
import jonas.exambyte.domain.model.Aufgabentyp;
import jonas.exambyte.domain.model.Quiz;
import jonas.exambyte.domain.service.ExambyteService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExambyteController {

    ExambyteService exambyteService;
    QuizSession quizSession;

    public ExambyteController(ExambyteService exambyteService, QuizSession quizSession) {
        this.exambyteService = exambyteService;
        this.quizSession = quizSession;
    }

    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        List<Quiz> alleQuizze = exambyteService.alleQuizze();
        model.addAttribute("alleQuizze", alleQuizze);
        return "home";
    }
    @GetMapping("/form")
    public String createQuizForm(Model model){
        model.addAttribute("quiz", quizSession.getQuizdto());
        return "edit";
    }
    // @GetMapping("/edit/{id}")
    // public String editQuiz(Model model, @PathVariable("id") long id){
    //     Quiz quiz = exambyteService.findQuizById(id);
    //     model.addAttribute("quiz", quiz);
    //     model.addAttribute("aufgabenListe", new ArrayList<Aufgabe>());

    //     return "edit";
    // }
    @PostMapping("/form/details")
    public String addQuizDetails(@RequestParam @DateTimeFormat(pattern="dd-MMM-YYYY")LocalDateTime startTime,
    @RequestParam @DateTimeFormat(pattern="dd-MMM-YYYY")LocalDateTime endTime){
        QuizDto quizDto = quizSession.getQuizdto();
        quizDto.setStartTime(startTime);
        quizDto.setEndTime(endTime);

        return "redirect:/form";
    }
    @PostMapping("/form/add")
    public String addTask(@RequestParam String frage, 
    @RequestParam Aufgabentyp aufgabentyp){
        QuizDto quizDto = quizSession.getQuizdto();
        AufgabeDto aufgabeDto = new AufgabeDto();
        aufgabeDto.setFrage(frage);
        aufgabeDto.setAufgabentyp(aufgabentyp);
        quizDto.getAufgaben().add(new Aufgabe(aufgabeDto.getFrage(), aufgabeDto.getAufgabentyp()));

        return "redirect:/form";
    }
    @PostMapping("/form/submit")
    public String submitQuiz(){
        QuizDto quizDto = quizSession.getQuizdto();
        exambyteService.saveQuiz(quizDto);
        quizSession.clear();

        return "redirect:/home";
    }
    @PostMapping("/form/cancel")
    public String cancelQuiz(){
        quizSession.clear();
        return "redirect:/home";
    }

    @GetMapping("/inspect/{quizID}")
    public String inspectQuiz(@PathVariable("quizID") long quizID, Model model){
        Quiz quiz = exambyteService.findQuizById(quizID);
        model.addAttribute("alleAufgaben", quiz.getAlleAufgaben());

        return "inspect";
    }
    @PostMapping("/home/delete")
    public String deleteQuiz(@RequestParam("id") long id){
        exambyteService.deleteQuizById(id);
        return "redirect:/home";
    }

}
