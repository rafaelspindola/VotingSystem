package com.Challenge.VotingSystem.repository;

import com.Challenge.VotingSystem.entity.Matter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatterRepository
        extends JpaRepository<Matter, Long> {

}
