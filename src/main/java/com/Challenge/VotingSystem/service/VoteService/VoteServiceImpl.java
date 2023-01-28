package com.Challenge.VotingSystem.service.VoteService;

import com.Challenge.VotingSystem.entity.Vote;
import com.Challenge.VotingSystem.repository.VoteRepository;

import java.util.List;

public class VoteServiceImpl implements VoteService{


    VoteRepository voteRepository;

    @Override
    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    public Vote findById(Long id) {
        return voteRepository.findById(id).get();
    }

    public Vote save(Vote vote) {
        return voteRepository.save(vote);
    }

    public Vote countVote() {

    }

}
