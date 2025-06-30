package com.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    private String text;

    public Message() {}

    public Message(String text) {
        this.text = text;
    }

    public Long getId() { return id; }
    public String getText() { return text; }
    public void setId(Long id) { this.id = id; }
    public void setText(String text) { this.text = text; }
}
