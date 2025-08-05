package com.example.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Entity
public class CastMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstAppearance;
    private static final Logger logger = LogManager.getLogger(CastMember.class);

    public CastMember() {}

    public CastMember(String name, String firstAppearance) {
        this.name = name;
        this.firstAppearance = firstAppearance;
        logger.info("CastMember entity created: {} in {}", name, firstAppearance);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFirstAppearance() { return firstAppearance; }
    public void setFirstAppearance(String firstAppearance) { this.firstAppearance = firstAppearance; }
}
