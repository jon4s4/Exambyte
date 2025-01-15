package jonas.exambyte.domain.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Aufgabe(@NotBlank(message = "darf nicht leer sein") String frage, 
@NotNull(message = "wähl einen aufgabentyp aus") Aufgabentyp aufgabentyp){
    public Aufgabe {
        if (aufgabentyp == null) {
            aufgabentyp = Aufgabentyp.FREITEXT;
        }
    }
}
