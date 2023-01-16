package com.Challenge.VotingSystem.service.MatterService;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.repository.MatterRepository;
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

    public void deleteById(Long id) {
        matterRepository.deleteById(id);
    }
}
