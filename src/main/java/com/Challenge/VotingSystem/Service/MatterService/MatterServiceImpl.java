package com.Challenge.VotingSystem.Service.MatterService;

import com.Challenge.VotingSystem.Entity.Matter;
import com.Challenge.VotingSystem.Repository.MatterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatterServiceImpl implements MatterService {

    MatterRepository matterRepository;

    public List<Matter> findAll() {
        return matterRepository.findAll();
    }

    public Matter findById(Long id) {
        return matterRepository.findById(id).get();
    }

    public Matter save(Matter matter) {
        return matterRepository.save(matter);
    }

    public Matter deleteById(Long id) {
        return matterRepository.deleteById(id);
    }
}
