package com.Challenge.VotingSystem.repository;

import com.Challenge.VotingSystem.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository
        extends JpaRepository<Session, Long> { }
