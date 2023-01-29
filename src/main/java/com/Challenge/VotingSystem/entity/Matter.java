package com.Challenge.VotingSystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Matter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @JsonProperty
    private Long id;

    @NotBlank
    @Column
    private String text;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Column
    private LocalDate date;

    @NotBlank
    @Column
    private String author;
}
