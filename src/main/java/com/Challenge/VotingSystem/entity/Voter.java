package com.Challenge.VotingSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Voter {

    @JsonBackReference
    @ManyToMany(mappedBy = "voters")
    private List<Matter> matters = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    // method hasVoted, passar ID usuário
    // .hasVoted(Tipo nomeDoUsuario)
    //if(hasVoted igual a true) faz a else faz b
    // concatenar propriedades
    //findByAuthor(String author);
    //https://www.baeldung.com/spring-data-derived-queries


    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String cpf;

    @Column
    @NotBlank
    private String voteType;

//    @Column
//    @NotBlank
//    @OneToMany(mappedBy = "voter")
//    private List<Vote> votes;
}
