package com.example.RestAPI.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student tushar= new Student(
                    "Tushar",
                    LocalDate.of(2000, Month.APRIL,27),
                    "tusharrawat517@gmail.com"
            );
            Student alex= new Student(
                    "Alex",
                    LocalDate.of(1999, Month.APRIL,24),
                    "alexWilliams@gmail.com"
            );

            repository.saveAll(
                    List.of(tushar,alex)
            );
        };

    }
}
