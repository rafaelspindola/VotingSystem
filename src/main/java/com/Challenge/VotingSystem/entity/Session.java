package com.Challenge.VotingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private int sessionDuration;

    private LocalDateTime initialized_at;

    private LocalDateTime finalized_at;
    // .now()

//    public void getResult() {
//        if(yesVotes > noVotes) {
//            System.out.println("The matter has been approved.");
//        } else if (noVotes > yesVotes) {
//            System.out.println("The matter has been rejected.");
//        } else {
//            System.out.println("It's a tie. Look for rules related to solving ties.");
//        }
//    }
}
