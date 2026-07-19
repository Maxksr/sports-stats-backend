package com.random.modnar.match;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {

    private final LeaderboardServic leaderboardServic;

    public LeaderboardController(LeaderboardServic leaderboardServic) {
        this.leaderboardServic = leaderboardServic;
    }

     public List<PlayerMatchStats> goals() {
        return leaderboardServic.topScorers();
     }

     public List<PlayerMatchStats> assists() {
        return leaderboardServic.topAssists();
     }

}