package jonas.exambyte.adapter.db;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;

public record Quiz(@Id Long id, List<Aufgabe> aufgaben, LocalDateTime startTime, LocalDateTime endTime){
}
