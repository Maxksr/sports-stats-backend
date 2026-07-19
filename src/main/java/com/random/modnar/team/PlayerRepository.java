package com.random.modnar.team;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    Page<Player> findByTeamId(Long teamId, Pageable pageable);

    Page<Player> findByPosition(String position, Pageable pageable);

    Page<Player> findByTeamIdAndPosition(Long teamId, String position, Pageable pageable);
}