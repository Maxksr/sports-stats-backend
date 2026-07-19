package com.random.modnar.team;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerStatsService {

    private final PlayerStatsRepository playerStatsRepository;

    public PlayerStatsService(PlayerStatsRepository playerStatsRepository) {
        this.playerStatsRepository = playerStatsRepository;
    }

    public PlayerStats addStats(PlayerStats stats) {
        return playerStatsRepository.save(stats);
    }

    public List<PlayerStats> getStatsByPlayer(Long playerId) {
        return playerStatsRepository.findByPlayerId(playerId);
    }
}
