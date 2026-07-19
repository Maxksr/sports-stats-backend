package com.random.modnar.team;
import java.util.List;

public interface TeamServices {
    List<Team> getAllTeams();

    Team getTeam(Long id);

    Team createTeam(Team team);

    void deleteTeam(Long id);
}
