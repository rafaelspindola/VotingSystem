package com.Challenge.VotingSystem.service.VoteService;

import com.Challenge.VotingSystem.entity.Vote;

import java.util.List;

public interface VoteService {

    List<Vote> findAll();
    Vote findById(Long id);
    Vote save(Vote vote);
}
