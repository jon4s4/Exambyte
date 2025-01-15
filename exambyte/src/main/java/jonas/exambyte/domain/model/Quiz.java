package jonas.exambyte.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private Long id;

    private List<Aufgabe> alleAufgaben = new ArrayList<>();

    private LocalDateTime startTime;

    private LocalDateTime endTime;
    

    public Quiz(Long id, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public Quiz(LocalDateTime starTime, LocalDateTime endTime){
        this.startTime = starTime;
        this.endTime = endTime;
    }
    public Quiz(Long id) {
        this.id = id;
    }
    public Quiz(){}

    public Long getId() {
        return id;
    }

    public List<Aufgabe> getAlleAufgaben() {
        return alleAufgaben;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void addAufgabe(Aufgabe aufgabe){
        alleAufgaben.add(aufgabe);
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public void setAlleAufgabe(List<Aufgabe> aufgaben){
        this.alleAufgaben = aufgaben;
    }
    
}
