package jonas.exambyte.adapter.controller;

import jonas.exambyte.application.QuizDto;
import jonas.exambyte.application.QuizSession;
import jonas.exambyte.domain.model.Aufgabe;
import jonas.exambyte.domain.model.Quiz;
import jonas.exambyte.domain.model.Zeitraum;
import jonas.exambyte.domain.service.ExambyteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

import java.time.LocalDateTime;
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
        QuizDto newQuiz = quizSession.getQuizdto();
        if (newQuiz.getZeitraum() == null) {
            newQuiz.setZeitraum(new Zeitraum(LocalDateTime.now(), LocalDateTime.now()));
        }
        model.addAttribute("quiz", newQuiz);
        model.addAttribute("zeitraum", newQuiz.getZeitraum());
        return "edit";
    }
    @PostMapping("/form/details")
    public String addQuizDetails(@ModelAttribute("zeitraum") @Valid Zeitraum zeitraum, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "redirect:/form";
        }
        QuizDto quizDto = quizSession.getQuizdto();
        quizDto.setZeitraum(zeitraum);

        return "redirect:/form";
    }
    @PostMapping("/form/add")
    public String addTask(@Valid QuizDto quizDto, BindingResult bindingResult,
    Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("quiz", quizDto);
            return "edit";
        }
        quizDto.getAufgaben().add(new Aufgabe(quizDto.getCurrentAufgabe().frage(), quizDto.getCurrentAufgabe().aufgabentyp()));

        return "redirect:/form";
    }
    @PostMapping("/form/submit")
    public String submitQuiz(@Valid QuizDto quizDto, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("quiz", quizDto);
            return "edit";
        }

        exambyteService.saveQuiz(quizDto);
        quizSession.clear();

        return "redirect:/home";
    }
    @PostMapping("/form/cancel")
    public String cancelQuiz(){
        quizSession.clear();
        quizSession.getQuizdto().getAufgaben().clear();
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
