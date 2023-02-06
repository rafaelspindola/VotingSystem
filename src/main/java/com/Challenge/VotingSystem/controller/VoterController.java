package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Voter;
import com.Challenge.VotingSystem.service.VoterService.VoterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class VoterController {

    private final VoterService service;

    public VoterController(VoterService service) {
        this.service = service;
    }

    @GetMapping(value = "/api/v1/matters/{id}/voter")
    public ResponseEntity<List<Voter>> getVoters() {
        List<Voter> voters = service.findAll();
        return ResponseEntity.ok().body(voters);
    }

    @GetMapping(value = "/voter/{id}")
    public ResponseEntity<Voter> getVoterById(@PathVariable("id") Long id) {
        Voter voter = service.findById(id);
        return ResponseEntity.ok(voter);
    }

//    @PostMapping("/api/v1/matters/{id}/voters")
//    public ResponseEntity<Voter> createVoter(@RequestBody Voter voter) {
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(service.save(voter));
//    }

    @PutMapping(value = "/api/v1/matters/{id}/voter") //vote
    public ResponseEntity<Voter> createVoter(@RequestBody Voter voter, @RequestParam Long matterId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(voter, matterId));
    }


}
