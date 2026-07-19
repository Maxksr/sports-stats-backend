package com.random.modnar.match;

import java.util.List;

public interface MatchServices {
    List<Match> getAllMatches();

    Match getMatch(Long id);

    Match createMatch(Match match);

    void deleteMatch(Long id);
}
