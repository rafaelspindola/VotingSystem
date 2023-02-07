package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Vote;
import com.Challenge.VotingSystem.service.VoteService.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping(value = "/api/v1/matters/{id}/vote")
    public ResponseEntity<List<Vote>> getVotes() {
        List<Vote> votes = voteService.findAll();
        return ResponseEntity.ok().body(votes);
    }

    @GetMapping(value = "/vote/{id}")
    public ResponseEntity<Vote> getVoterById(@PathVariable("id") Long id) {
        Vote vote = voteService.findById(id);
        return ResponseEntity.ok(vote);
    }

    @PutMapping(value = "/api/v1/matters/vote") //vote
    public ResponseEntity<Vote> createVoter(@RequestBody Vote vote, @RequestParam Long matterId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(voteService.save(vote, matterId));
    }
}
