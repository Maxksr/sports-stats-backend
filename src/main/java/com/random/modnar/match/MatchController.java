package com.random.modnar.match;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchServices matchService;

    public MatchController(MatchServices matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    public List<Match> getAll() {
        return matchService.getAllMatches();
    }

    @PostMapping
    public Match create(@RequestBody Match match) {
        return matchService.createMatch(match);
    }

    @GetMapping("/{id}")
    public Match getById(@PathVariable Long id) {
        return matchService.getMatch(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        matchService.deleteMatch(id);
    }
}