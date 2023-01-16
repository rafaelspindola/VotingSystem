package com.Challenge.VotingSystem.service.VoterService;

import com.Challenge.VotingSystem.entity.Voter;
import com.Challenge.VotingSystem.repository.VoterRepository;
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

}
