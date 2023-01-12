package com.Challenge.VotingSystem.Service.VoteService;

import com.Challenge.VotingSystem.Entity.Vote;

import java.util.List;

public interface VoteService {

    List<Vote> findAll();
    Vote findById(Long id);
    Vote save(Vote vote);
    Vote deleteById(Long id);
}
