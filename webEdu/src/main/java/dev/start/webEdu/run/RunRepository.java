package dev.start.webEdu.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    
    private List<Run> runs = new ArrayList<>();

    List<Run> getRunner() {
        return runs;
    }

    Optional<Run> getById(Integer id) {
        return runs.stream().filter(Run -> Run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = getById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(
            1,
            "Morning Run",
            LocalDateTime.now().minus(3, ChronoUnit.HOURS),
            LocalDateTime.now().minus(1, ChronoUnit.HOURS),
            5,
            Location.OUTDOOR
        ));

        runs.add(new Run(
            2,
            "Evening Gym",
            LocalDateTime.now().minus(5, ChronoUnit.HOURS),
            LocalDateTime.now().minus(2, ChronoUnit.HOURS),
            8,
            Location.INDOOR
        ));
    }

    public List<Run> getRuns() {
        return runs;
    }

    public void setRuns(List<Run> runs) {
        this.runs = runs;
    }

}
