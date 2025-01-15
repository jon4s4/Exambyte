package jonas.exambyte.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private Long id;

    private List<Aufgabe> alleAufgaben = new ArrayList<>();

    Zeitraum zeitraum;
    
    public Quiz(Long id, Zeitraum zeitraum) {
        this.id = id;
    }
    
    public Quiz(Zeitraum zeitraum) {
        this.zeitraum = zeitraum;
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

    public void addAufgabe(Aufgabe aufgabe){
        alleAufgaben.add(aufgabe);
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setAlleAufgabe(List<Aufgabe> aufgaben){
        this.alleAufgaben = aufgaben;
    }

    public void setAlleAufgaben(List<Aufgabe> alleAufgaben) {
        this.alleAufgaben = alleAufgaben;
    }

    public Zeitraum getZeitraum() {
        return zeitraum;
    }

    public void setZeitraum(Zeitraum zeitraum) {
        this.zeitraum = zeitraum;
    }
    
}
