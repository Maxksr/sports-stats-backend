package com.random.modnar.team;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;


    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public PlayerResponse createPlayer(PlayerRequest request) {


        Player player = new Player();

        player.setName(request.getName());
        player.setPosition(request.getPosition());
        player.setAge(request.getAge());


        Player savedPlayer = playerRepository.save(player);


        PlayerResponse response = new PlayerResponse();

        response.setId(savedPlayer.getId());
        response.setName(savedPlayer.getName());
        response.setPosition(savedPlayer.getPosition());
        response.setAge(savedPlayer.getAge());


        return response;
    }

    private PlayerResponse toResponse(Player player) {

        PlayerResponse response = new PlayerResponse();

        response.setId(player.getId());
        response.setName(player.getName());
        response.setPosition(player.getPosition());
        response.setAge(player.getAge());

        return response;
    }



    public List<PlayerResponse> getAllPlayer() {

        return playerRepository.findAll()
                .stream()
                .map(player -> {

                    PlayerResponse response = new PlayerResponse();

                    response.setId(player.getId());
                    response.setName(player.getName());
                    response.setPosition(player.getPosition());
                    response.setAge(player.getAge());

                    return response;

                })
                .toList();
    }

    public Page<PlayerResponse> getPlayersByTeam(Long teamId, Pageable pageable) {

        return playerRepository.findByTeamId(teamId, pageable)
                .map(this::toResponse);
    }

    public Page<PlayerResponse> getPlayers(
            Long teamId,
            String position,
            Pageable pageable
    ) {

        Page<Player> players;

        if (teamId != null && position != null) {
            players = playerRepository.findByTeamIdAndPosition(teamId, position, pageable);

        } else if (teamId != null) {
            players = playerRepository.findByTeamId(teamId, pageable);

        } else if (position != null) {
            players = playerRepository.findByPosition(position, pageable);

        } else {
            players = playerRepository.findAll(pageable);
        }

        return players.map(this::toResponse);
    }
}