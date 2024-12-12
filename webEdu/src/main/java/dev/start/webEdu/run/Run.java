package dev.start.webEdu.run;

import java.lang.reflect.AccessFlag.Location;
import java.time.LocalDateTime;

public record Run(
    Integer id,
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    Integer miles,
    Location location
) {
    public Run {
        if (completedOn != null && startedOn != null && !completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }
}
