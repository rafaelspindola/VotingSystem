package com.Challenge.VotingSystem.service.MatterService;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.repository.MatterRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Validated
@Service
public class MatterService {

    MatterRepository matterRepository;

    public MatterService(MatterRepository matterRepository) {
        this.matterRepository = matterRepository;
    }

    @GetMapping
    public List<Matter> findAll() {
        return matterRepository.findAll();
    }

    public Optional<Matter> findById(@PathVariable Long id) {
        return matterRepository.findById(id);
    }

    public Matter save(Matter matter) {
        return matterRepository.save(matter);
    }

    public void deleteById(Long id) {
        matterRepository.deleteById(id);
    }
}
