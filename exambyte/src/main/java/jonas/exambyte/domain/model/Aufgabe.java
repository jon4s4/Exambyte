package jonas.exambyte.domain.model;

import jakarta.validation.constraints.NotBlank;

public record Aufgabe(@NotBlank(message = "gib eine Aufgabe ein") String frage, 
Aufgabentyp aufgabentyp){
}
