package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.repository.MatterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matters")
public class MatterController {
//        @Autowired
//    MatterService service;
//    private final MatterService service;

    public MatterController(MatterRepository repository) {
        this.repository = repository;
    }

    private MatterRepository repository;

//    public MatterController(MatterService service) {
//        this.service = service;
//    }

    @GetMapping
    public ResponseEntity<List<Matter>> findAll() {
        List<Matter> matters = repository.findAll();
        return ResponseEntity.ok().body(matters);
    }

//    @GetMapping(value = "matter/{id}")
//    public ResponseEntity<Matter> findMatterById(@PathVariable("id") Long id) {
//        Matter matter = service.findById(id);
//        return ResponseEntity.ok(matter);
//    }

    @PostMapping
    public ResponseEntity<Matter> save(@RequestBody Matter matter) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(matter));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Matter> delete(@PathVariable("id") Long id) {
//        service.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }


    // create voter, session, matter


}