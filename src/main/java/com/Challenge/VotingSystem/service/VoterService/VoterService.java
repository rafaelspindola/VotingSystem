package com.Challenge.VotingSystem.service.VoterService;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.entity.Voter;
import com.Challenge.VotingSystem.repository.VoterRepository;
import com.Challenge.VotingSystem.service.MatterService.MatterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterService{

    MatterService matterService;

    VoterRepository voterRepository;

    public VoterService(VoterRepository voterRepository, MatterService matterService) {
        this.voterRepository = voterRepository;
        this.matterService = matterService;
    }

    public List<Voter> findAll() {
        return voterRepository.findAll();
    }

    public Voter findById(Long id) {
        return voterRepository.findById(id).get();
    }

    public Voter save(Voter voter, Long matterId) {
        Optional<Matter> selectedMatter = matterService.findById(matterId);
//        voter.getMatters().add(selectedMatter.get());
        selectedMatter.get().getVoters().add(voter);
//        matterService.save(selectedMatter.get());
        return voterRepository.save(voter);
    }

}
