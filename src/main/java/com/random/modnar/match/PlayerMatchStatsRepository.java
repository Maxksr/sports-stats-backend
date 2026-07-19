package com.random.modnar.match;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerMatchStatsRepository extends JpaRepository<PlayerMatchStats, Long> {

    List<PlayerMatchStats> findTop10ByOrderByGoalsDesc();

    List<PlayerMatchStats> findTop10ByOrderByAssistsDesc();

    List<PlayerMatchStats> findByPlayerId(Long playerId);

    List<PlayerMatchStats> findByMatchId(Long matchId);
}