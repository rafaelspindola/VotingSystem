package com.Challenge.VotingSystem.service.SessionService;

import com.Challenge.VotingSystem.entity.Session;
import com.Challenge.VotingSystem.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//    public Session getDuration(int duration) {
//
//    }

    public String getVote(String vote) {
        List<String> votes = new ArrayList<>();
        votes.add("Yes");
        votes.add("No");
        return "Your vote was: " + votes.add();
    }

    public int getVote(int vote) {
        int yesVotes = 0;
        int noVotes = 0;
        int result = yesVotes - noVotes;
        if (vote == 1) {
            yesVotes++;
        } else if (vote == 2) {
            noVotes++;
        } else {
            System.out.println("Invalid vote.");
        }

        if (yesVotes > noVotes) {
            System.out.println("The matter has been approved.");
        } else if (noVotes > yesVotes) {
            System.out.println("The matter has been rejected.");
        } else {
            System.out.println("It's a tie. Look for rules related to solving ties.");
        }
        return result;
    }

    public int countVotes() {

    }
}
