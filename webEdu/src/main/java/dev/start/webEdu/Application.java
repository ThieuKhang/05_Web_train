package dev.start.webEdu;

import dev.start.webEdu.run.Run;
import dev.start.webEdu.run.Location;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Run runner_1 = new Run(
                1,
                "Beach Run",
                LocalDateTime.now().minusHours(3),
                LocalDateTime.now().minusHours(1),
                10,
                Location.OUTDOOR
            );

            System.out.println(runner_1);
        };
    }
}

