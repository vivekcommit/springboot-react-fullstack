package com.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Logger logger = LogManager.getLogger(MessageRepository.class);
}
