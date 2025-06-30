package com.example.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CastMemberDataLoader {
    @Bean
    CommandLineRunner initDatabase(CastMemberRepository repository) {
        return args -> {
            // Insert 1000 cast members
            for (int i = 1; i <= 1000; i++) {
                String name = "Actor " + i;
                String movie = "Movie " + ((i % 100) + 1) + " (20" + String.format("%02d", (i % 25) + 1) + ")";
                repository.save(new CastMember(name, movie));
            }
        };
    }
}
