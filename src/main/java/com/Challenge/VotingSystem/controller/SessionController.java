package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Session;
import com.Challenge.VotingSystem.service.SessionService.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sessions")
public class SessionController {

    private final SessionService service;

    public SessionController(SessionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Session>> getSessions() {
        List<Session> sessions = service.findAll();
        return ResponseEntity.ok().body(sessions);
    }

    @GetMapping(value = "session/{id}")
    public ResponseEntity<Session> findSessionById(@PathVariable("id") Long id) {
        Session session = service.findById(id);
        return ResponseEntity.ok(session);
    }

    @PostMapping // button to create session and count votes, show a dialog with results
    public ResponseEntity<Session> createSession(@RequestBody Session session) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(session));
    }

    @DeleteMapping
    public ResponseEntity<Session> deleteSession(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
