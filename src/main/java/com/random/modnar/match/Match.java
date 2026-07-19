package com.random.modnar.match;

import com.random.modnar.team.Team;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Team homeTeam;

    @ManyToOne
    private Team awayTeam;

    private int homeScore;

    private int awayScore;

    private String matchDate;
}
