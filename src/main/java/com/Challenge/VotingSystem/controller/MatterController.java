package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.service.MatterService.MatterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/matters")
public class MatterController {

    private final MatterService matterService;

    public MatterController(MatterService matterService) {
        this.matterService = matterService;
    }

    @GetMapping
    public ResponseEntity<List<Matter>> findAll() {
        List<Matter> matters = matterService.findAll();
        return ResponseEntity.ok().body(matters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matter> findById(@PathVariable Long id) {
        return matterService.findById(id).map(recordFound -> ResponseEntity.ok().body(recordFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Matter> createMatter(@RequestBody Matter matter) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(matterService.save(matter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Matter> delete(@PathVariable("id") Long id) {
        matterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}