package com.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private static final Logger logger = LogManager.getLogger(Message.class);

    public Message() {}

    public Message(String text) {
        this.text = text;
        logger.info("Message entity created with text: {}", text);
    }

    public Long getId() { return id; }
    public String getText() { return text; }
    public void setId(Long id) { this.id = id; }
    public void setText(String text) { this.text = text; }
}
