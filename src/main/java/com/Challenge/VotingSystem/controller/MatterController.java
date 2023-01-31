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
    private final MatterService service;

    public MatterController(MatterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Matter>> getMatters() {
        List<Matter> matters = service.findAll();
        return ResponseEntity.ok().body(matters);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Matter> getMatterById(@PathVariable("id") Long id) {
        Matter matter = service.findById(id);
        return ResponseEntity.ok(matter);
    }

    @PostMapping
    public ResponseEntity<Matter> createMatter(@RequestBody Matter matter) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(matter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Matter> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}