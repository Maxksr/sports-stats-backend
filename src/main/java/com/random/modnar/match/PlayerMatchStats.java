package com.random.modnar.match;

import com.random.modnar.team.Player;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PlayerMatchStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int goals;

    private int assists;

    private int minutesPlayed;

    private double rating;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Match match;
}
