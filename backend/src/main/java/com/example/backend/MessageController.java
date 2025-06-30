package com.example.backend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageRepository repo;

    public MessageController(MessageRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Message> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Message create(@RequestBody Message message) {
        return repo.save(message);
    }
}
