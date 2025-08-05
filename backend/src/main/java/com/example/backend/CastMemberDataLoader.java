package com.example.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Configuration
public class CastMemberDataLoader {
    private static final Logger logger = LogManager.getLogger(CastMemberDataLoader.class);
    @Bean
    CommandLineRunner initDatabase(CastMemberRepository repository) {
        return args -> {
            logger.debug("[WORKFLOW] Entered initDatabase() in CastMemberDataLoader");
            logger.info("Initializing database with 1000 cast members");
            // Insert 1000 cast members
            for (int i = 1; i <= 1000; i++) {
                String name = "Actor " + i;
                String movie = "Movie " + ((i % 100) + 1) + " (20" + String.format("%02d", (i % 25) + 1) + ")";
                repository.save(new CastMember(name, movie));
            }
            logger.debug("[WORKFLOW] Finished inserting cast members in initDatabase()");
            logger.info("Database initialization complete");
        };
    }
}
