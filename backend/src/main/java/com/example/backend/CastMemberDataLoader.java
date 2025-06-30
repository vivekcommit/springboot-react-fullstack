package com.example.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CastMemberDataLoader {
    @Bean
    CommandLineRunner initDatabase(CastMemberRepository repository) {
        return args -> {
            repository.save(new CastMember("Robert Downey Jr.", "Iron Man (2008)"));
            repository.save(new CastMember("Chris Evans", "Captain America: The First Avenger (2011)"));
            repository.save(new CastMember("Scarlett Johansson", "Iron Man 2 (2010)"));
            repository.save(new CastMember("Chris Hemsworth", "Thor (2011)"));
            repository.save(new CastMember("Mark Ruffalo", "The Avengers (2012)"));
            repository.save(new CastMember("Tom Holland", "Captain America: Civil War (2016)"));
        };
    }
}
