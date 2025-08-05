package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequestMapping("/api/cast")
public class CastMemberController {
    @Autowired
    private CastMemberRepository castMemberRepository;
    private static final Logger logger = LogManager.getLogger(CastMemberController.class);

    @GetMapping
    public List<CastMember> getAllCast() {
        logger.debug("[WORKFLOW] Entered getAllCast() in CastMemberController");
        logger.info("Fetching all cast members");
        try {
            return castMemberRepository.findAll();
        } catch (Exception ex) {
            logger.error("Exception in getAllCast(): ", ex);
            throw ex;
        } finally {
            logger.debug("[WORKFLOW] Exiting getAllCast() in CastMemberController");
        }
    }
}
