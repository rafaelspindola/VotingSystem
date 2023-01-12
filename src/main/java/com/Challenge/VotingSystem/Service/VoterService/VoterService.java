package com.Challenge.VotingSystem.Service.VoterService;

import com.Challenge.VotingSystem.Entity.Voter;

import java.util.List;

public interface VoterService {

    List<Voter> findAll();
    Voter findById(Long id);
    Voter save(Voter voter);
    Voter deleteById(Long id);
}
