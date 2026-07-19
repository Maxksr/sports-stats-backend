package com.random.modnar.team;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int goals;

    private int assists;

    private int matchesPlayed;

    private double rating;


    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
}
