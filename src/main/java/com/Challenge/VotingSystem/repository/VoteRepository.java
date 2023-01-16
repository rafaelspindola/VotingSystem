package com.Challenge.VotingSystem.repository;

import com.Challenge.VotingSystem.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository
        extends JpaRepository<Vote, Long> { }
