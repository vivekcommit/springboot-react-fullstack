package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cast")
public class CastMemberController {
    @Autowired
    private CastMemberRepository castMemberRepository;

    @GetMapping
    public List<CastMember> getAllCast() {
        return castMemberRepository.findAll();
    }
}
