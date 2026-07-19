package com.random.modnar.match;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderboardServic {
    private final PlayerMatchStatsRepository playerMatchStatsRepository;

    public LeaderboardServic(PlayerMatchStatsRepository playerMatchStatsRepository) {
        this.playerMatchStatsRepository = playerMatchStatsRepository;
    }

    public List<PlayerMatchStats> topScorers() {
        return playerMatchStatsRepository.findTop10ByOrderByGoalsDesc();
    }

    public List<PlayerMatchStats> topAssists() {
        return playerMatchStatsRepository.findTop10ByOrderByAssistsDesc();
    }
}
