package com.example.backend;

import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageRepository repo;
    private static final Logger logger = LogManager.getLogger(MessageController.class);

    public MessageController(MessageRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Message> getAll() {
        logger.debug("[WORKFLOW] Entered getAll() in MessageController");
        logger.info("Fetching all messages");
        try {
            return repo.findAll();
        } catch (Exception ex) {
            logger.error("Exception in getAll(): ", ex);
            throw ex;
        } finally {
            logger.debug("[WORKFLOW] Exiting getAll() in MessageController");
        }
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        logger.debug("[WORKFLOW] Entered create() in MessageController with text: {}", message.getText());
        logger.info("Creating new message: {}", message.getText());
        try {
            return repo.save(message);
        } catch (Exception ex) {
            logger.error("Exception in create(): ", ex);
            throw ex;
        } finally {
            logger.debug("[WORKFLOW] Exiting create() in MessageController");
        }
    }
}
