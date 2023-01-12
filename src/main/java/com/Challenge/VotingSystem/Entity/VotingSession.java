package com.Challenge.VotingSystem.Entity;

import jakarta.persistence.*;
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
public class VotingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private List<Vote> votes;

    @Column
    private int sessionDuration;

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
