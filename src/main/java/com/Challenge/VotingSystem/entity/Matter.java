package com.Challenge.VotingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;


    @Column
    private String matter;

//    @Column
//    private Timestamp date;

    @Column
    private String author;
}
