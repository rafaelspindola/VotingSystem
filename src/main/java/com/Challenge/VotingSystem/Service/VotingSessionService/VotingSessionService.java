package com.Challenge.VotingSystem.Service.VotingSessionService;

import com.Challenge.VotingSystem.Entity.VotingSession;

import java.util.List;

public interface VotingSessionService {

    List<VotingSession> findAll();
    VotingSession findById(Long id);
    VotingSession save(VotingSession session);
    VotingSession delete(Long id);
}
