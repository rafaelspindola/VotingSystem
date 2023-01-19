package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Voter;
import com.Challenge.VotingSystem.service.VoterService.VoterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/voters")
public class VoterController {

    private final VoterService service;

    public VoterController(VoterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Voter>> getVoters() {
        List<Voter> voters = service.findAll();
        return ResponseEntity.ok().body(voters);
    }

    @GetMapping(value = "/voter/{id}")
    public ResponseEntity<Voter> getVoterById(@PathVariable("id") Long id) {
        Voter voter = service.findById(id);
        return ResponseEntity.ok(voter);
    }

    @PostMapping
    public ResponseEntity<Voter> createVoter(@RequestBody Voter voter) {
        Voter created = service.save(voter);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

}
