package com.Challenge.VotingSystem.Repository;

import com.Challenge.VotingSystem.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository
        extends JpaRepository<Vote, Long> { }
