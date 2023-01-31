package com.Challenge.VotingSystem.service.VoteService;

import com.Challenge.VotingSystem.entity.Vote;
import com.Challenge.VotingSystem.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VoteServiceImpl implements VoteService{


    VoteRepository voteRepository;

    public VoteServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

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

//    public Vote countVote() {
//
//    }

}
