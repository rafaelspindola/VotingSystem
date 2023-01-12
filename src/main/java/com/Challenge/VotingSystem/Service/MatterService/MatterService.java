package com.Challenge.VotingSystem.Service.MatterService;

import com.Challenge.VotingSystem.Entity.Matter;

import java.util.List;

public interface MatterService {

    List<Matter> findAll();
    Matter findById(Long id);
    Matter save(Matter matter);
    Matter deleteById(Long id);
}
