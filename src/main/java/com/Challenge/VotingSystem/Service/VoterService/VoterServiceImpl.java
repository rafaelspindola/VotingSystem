package com.Challenge.VotingSystem.Service.VoterService;

import com.Challenge.VotingSystem.Entity.Voter;
import com.Challenge.VotingSystem.Repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterServiceImpl implements VoterService {

    VoterRepository voterRepository;

    public List<Voter> findAll() {
        return voterRepository.findAll();
    }

    public Voter findById(Long id) {
        return voterRepository.findById(id).get();
    }

    public Voter save(Voter voter) {
        return voterRepository.save(voter);
    }

    public Voter deleteById(Long id) {
        return voterRepository.deleteById(id);
    }
}
