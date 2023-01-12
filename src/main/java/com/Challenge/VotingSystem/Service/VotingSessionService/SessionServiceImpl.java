package com.Challenge.VotingSystem.Service.VotingSessionService;

import com.Challenge.VotingSystem.Entity.VotingSession;
import com.Challenge.VotingSystem.Repository.VotingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements VotingSessionService {

    VotingSessionRepository sessionRepository;

    public List<VotingSession> findAll() {
        return sessionRepository.findAll();
    }

    public VotingSession findById(Long id) {
        return sessionRepository.findById(id).get();
    }

    public VotingSession save(VotingSession session) {
        return sessionRepository.save(session);
    }

    public VotingSession delete(Long id) {
       return sessionRepository.deleteById(id);
    }
}
