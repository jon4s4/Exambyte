package jonas.exambyte.application;

import jonas.exambyte.domain.model.Aufgabentyp;

public class AufgabeDto{
    private String frage;
    private Aufgabentyp aufgabentyp;

    public AufgabeDto(){}

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public Aufgabentyp getAufgabentyp() {
        return aufgabentyp;
    }

    public void setAufgabentyp(Aufgabentyp aufgabentyp) {
        this.aufgabentyp = aufgabentyp;
    }

    public AufgabeDto(String frage, Aufgabentyp aufgabentyp) {
        this.frage = frage;
        this.aufgabentyp = aufgabentyp;
    }

    
}
