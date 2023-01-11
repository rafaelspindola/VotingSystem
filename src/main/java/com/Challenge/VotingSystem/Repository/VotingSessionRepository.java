package com.Challenge.VotingSystem.Repository;

import com.Challenge.VotingSystem.Entity.VotingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingSessionRepository
        extends JpaRepository<VotingSession, Long> { }
