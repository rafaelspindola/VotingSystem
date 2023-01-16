package com.Challenge.VotingSystem.service.VoterService;

import com.Challenge.VotingSystem.entity.Voter;

import java.util.List;

public interface VoterService {

    List<Voter> findAll();
    Voter findById(Long id);
    Voter save(Voter voter);
}
