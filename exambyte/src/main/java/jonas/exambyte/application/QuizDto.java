package jonas.exambyte.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jonas.exambyte.domain.model.Aufgabe;

public class QuizDto{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Aufgabe> aufgaben = new ArrayList<>();
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
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
}


