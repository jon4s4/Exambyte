package jonas.exambyte.domain.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class Zeitraum {
    @NotNull
    LocalDateTime startTime;
    @NotNull
    LocalDateTime endTime;

    public Zeitraum(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

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

}
