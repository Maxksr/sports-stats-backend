package com.random.modnar.team;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamServices teamService;

    public TeamController(TeamServices teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> getAll() {
        return teamService.getAllTeams();
    }

    @PostMapping
    public Team create(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}