package com.random.modnar.team;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class PlayerStatsController {

    private final PlayerStatsService playerStatsService;

    public PlayerStatsController(PlayerStatsService playerStatsService) {
        this.playerStatsService = playerStatsService;
    }

    @PostMapping
    public PlayerStats addStats(@RequestBody PlayerStats stast) {
        return playerStatsService.addStats(stast);
    }

    @GetMapping("/player/{playerId}")
    public List<PlayerStats> getByPlayer(@PathVariable Long playerId) {
        return playerStatsService.getStatsByPlayer(playerId);
    }
}
