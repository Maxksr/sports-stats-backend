package com.random.modnar.team;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public PlayerResponse create(@Valid @RequestBody PlayerRequest request) {
        return playerService.createPlayer(request);
    }

    @GetMapping
    public Page<PlayerResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long teamId,
            @RequestParam(required = false) String position
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return playerService.getPlayers(teamId, position, pageable);
    }

    @GetMapping("/team/{teamId}")
    public Page<PlayerResponse> getByTeam(
            @PathVariable Long teamId,
            @RequestParam int page,
            @RequestParam int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return playerService.getPlayersByTeam(teamId, pageable);
    }
}