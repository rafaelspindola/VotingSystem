package com.Challenge.VotingSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Voter {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String cpf;

    @Column
    @NotBlank
    @OneToMany(mappedBy = "voter")
    private List<Vote> votes;

}
