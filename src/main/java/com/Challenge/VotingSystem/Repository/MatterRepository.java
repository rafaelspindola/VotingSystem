package com.Challenge.VotingSystem.Repository;

import com.Challenge.VotingSystem.Entity.Matter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatterRepository
        extends JpaRepository<Matter, Long> {

}
