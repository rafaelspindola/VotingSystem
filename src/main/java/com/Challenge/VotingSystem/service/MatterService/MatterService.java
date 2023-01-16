package com.Challenge.VotingSystem.service.MatterService;

import com.Challenge.VotingSystem.entity.Matter;

import java.util.List;

public interface MatterService {

    List<Matter> findAll();
    Matter findById(Long id);
    Matter save(Matter matter);
    void deleteById(Long id);
}
