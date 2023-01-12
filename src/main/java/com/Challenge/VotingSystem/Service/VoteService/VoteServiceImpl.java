package com.Challenge.VotingSystem.Service.VoteService;

import com.Challenge.VotingSystem.Entity.Vote;
import com.Challenge.VotingSystem.Repository.VoteRepository;

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

    public Vote deleteById(Long id) {
        return voteRepository.deleteById();
    }
}
