package com.Challenge.VotingSystem.repository;

import com.Challenge.VotingSystem.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository
        extends JpaRepository<Voter, Long> { }
