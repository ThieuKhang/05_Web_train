package dev.start.webEdu;

import dev.start.webEdu.run.Run;
import dev.start.webEdu.run.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Create a Run instance using the correct Location enum
            Run runner_1 = new Run(
                1,
                "Beach Run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(2, ChronoUnit.HOURS),
                10,
                Location.OUTDOOR
            );

            // Log the created Run object
            log.info("Run: " + runner_1);
        };
    }
}

