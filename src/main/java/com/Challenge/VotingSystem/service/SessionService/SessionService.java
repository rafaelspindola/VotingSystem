package com.Challenge.VotingSystem.service.SessionService;

import com.Challenge.VotingSystem.entity.Session;

import java.util.List;

public interface SessionService {

    List<Session> findAll();
    Session findById(Long id);
    Session save(Session session);
    void deleteById(Long id);
}
