package com.Challenge.VotingSystem.controller;

import com.Challenge.VotingSystem.entity.Matter;
import com.Challenge.VotingSystem.service.MatterService.MatterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MatterController {
//        @Autowired
//    MatterService service;
    private final MatterService service;

    public MatterController(MatterService service) {
        this.service = service;
    }

    @GetMapping(value = "matters")
    public ResponseEntity<List<Matter>> getMatters() {
        List<Matter> matters = service.findAll();
        return ResponseEntity.ok().body(matters);
    }

    @GetMapping(value = "matter/{id}")
    public ResponseEntity<Matter> findMatterById(@PathVariable("id") Long id) {
        Matter matter = service.findById(id);
        return ResponseEntity.ok(matter);
    }

    @PostMapping
    public ResponseEntity<Matter> save(@RequestBody Matter matter) {
        Matter created = service.save(matter);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Matter> delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    // create voter, session, matter


}