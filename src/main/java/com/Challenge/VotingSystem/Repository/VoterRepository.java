package com.Challenge.VotingSystem.Repository;

import com.Challenge.VotingSystem.Entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository
        extends JpaRepository<Voter, Long> { }
