package com.Challenge.VotingSystem.service.SessionService;

import com.Challenge.VotingSystem.entity.Session;
import com.Challenge.VotingSystem.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    SessionRepository sessionRepository;

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public Session findById(Long id) {
        return sessionRepository.findById(id).get();
    }

    public Session save(Session session) {
        return sessionRepository.save(session);
    }

    public void deleteById(Long id) {
       sessionRepository.deleteById(id);
    }

}
