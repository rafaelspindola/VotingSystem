package com.Challenge.VotingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vote {

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Session session;

    @ManyToOne
    @JoinColumn(name = "voter_id", nullable = false)
    private Voter voter;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    private String voteType;

//    enum VoteType {
//        YES(1), NO(2);
//
//        private int vote;
//
//        VoteType(int vote) {
//            this.vote = vote;
//        }
//    }
}

//        public void getVotes() {
//            int yesVotes = 0;
//            int noVotes = 0;
//            if (vote == 1) {
//                yesVotes += 1;
//            } else if (vote == 2) {
//                noVotes += 1;
//            }
//        }
//
//        public void getResults() {
//        }
//    }



    // post, vote creation

