package jonas.exambyte.application;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jonas.exambyte.domain.model.Aufgabe;
import jonas.exambyte.domain.model.Zeitraum;

public class QuizDto{
    @NotBlank(message = "gib eine Aufgabe ein")
    private Aufgabe currentAufgabe;

    @NotNull
    Zeitraum zeitraum;

    @NotEmpty(message = "Muss mindestens eine Aufgabe beinhalten")
    private List<Aufgabe> aufgaben = new ArrayList<>();
    
    public List<Aufgabe> getAufgaben() {
        return aufgaben;
    }
    
    public void setAufgaben(List<Aufgabe> aufgaben) {
        this.aufgaben = aufgaben;
    }
    public void addAufgabe(Aufgabe aufgabe){
        aufgaben.add(aufgabe);
    }
    public List<Aufgabe> getAlleAufgaben(){
        return aufgaben;
    }
    public Aufgabe getCurrentAufgabe() {
        return currentAufgabe;
    }
    public void setCurrentAufgabe(Aufgabe currentAufgabe) {
        this.currentAufgabe = currentAufgabe;
    }

    public Zeitraum getZeitraum() {
        return zeitraum;
    }

    public void setZeitraum(Zeitraum zeitraum) {
        this.zeitraum = zeitraum;
    }
}


