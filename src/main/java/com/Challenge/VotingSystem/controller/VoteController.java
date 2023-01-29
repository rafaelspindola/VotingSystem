package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Vote;
import com.Challenge.VotingSystem.service.VoteService.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("api/v1/votes")
public class VoteController {

    private VoteService service;

    public VoteController() {

    }

    public VoteController(VoteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Vote>> getVotes() {
        List<Vote> votes = service.findAll();
        return ResponseEntity.ok().body(votes);
    }

    @PostMapping //button to save vote (get CPF)
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
        Vote created = service.save(vote);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }
}
