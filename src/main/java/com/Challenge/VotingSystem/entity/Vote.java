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
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
//    // method hasVoted, passar ID usuário
//    // .hasVoted(Tipo nomeDoUsuario)
//    //if(hasVoted igual a true) faz a else faz b
//    // concatenar propriedades
//    //findByAuthor(String author);
//    //https://www.baeldung.com/spring-data-derived-queries

    @NotBlank
    @Column
    private String name;

    @NotBlank
    @Column
    private String cpf;

    @Column
    @NotBlank
    private String voteType;

    @JsonBackReference
    @ManyToMany(mappedBy = "votes")
    private List<Matter> matters = new ArrayList<>();

//    enum VoteType {
//        YES(1), NO(2);
//
//       private int vote;
//
//       VoteType(int vote) {
//           this.vote = vote;
//       }
//
//        public void getVotes() {
//            int yesVotes = 0;
//            int noVotes = 0;
//            if (vote == 1) {
//                yesVotes += 1;
//            } else if (vote == 2) {
//                noVotes += 1;
//            }
//        }
//    }
}


