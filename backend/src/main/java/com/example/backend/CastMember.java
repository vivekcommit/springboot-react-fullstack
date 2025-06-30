package com.example.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CastMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstAppearance;

    public CastMember() {}

    public CastMember(String name, String firstAppearance) {
        this.name = name;
        this.firstAppearance = firstAppearance;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFirstAppearance() { return firstAppearance; }
    public void setFirstAppearance(String firstAppearance) { this.firstAppearance = firstAppearance; }
}
