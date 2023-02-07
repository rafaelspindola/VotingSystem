package com.Challenge.VotingSystem.service.VoteService;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.entity.Vote;
import com.Challenge.VotingSystem.repository.VoteRepository;
import com.Challenge.VotingSystem.service.MatterService.MatterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService{


    MatterService matterService;

    VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository, MatterService matterService) {
        this.voteRepository = voteRepository;
        this.matterService = matterService;
    }

    public List<Vote> findAll() {
        return voteRepository.findAll();
    }

    public Vote findById(Long id) {
        return voteRepository.findById(id).get();
    }

    public Vote save(Vote vote, Long matterId) {
        Optional<Matter> selectedMatter = matterService.findById(matterId);
        selectedMatter.get().getVotes().add(vote);
        return voteRepository.save(vote);
    }

//    public Vote save(Vote vote, Long matterId) {
//        Optional<Matter> selectedMatter = matterService.findById(matterId);
//        selectedMatter.get().getVoters().add(vote);
//        return voteRepository.save(vote);
//    }

}
