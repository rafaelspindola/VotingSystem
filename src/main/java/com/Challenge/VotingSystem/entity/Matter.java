package com.Challenge.VotingSystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @JsonProperty("_id")
    private Long id;

    @Column
    private String matter;

    @Column
    private LocalDate date;

    @Column
    private String author;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "matter_voters",
            joinColumns = @JoinColumn(name = "matter_id"),
            inverseJoinColumns = @JoinColumn(name = "voter_id")
    )
    private List<Voter> voters = new ArrayList<>();
}
