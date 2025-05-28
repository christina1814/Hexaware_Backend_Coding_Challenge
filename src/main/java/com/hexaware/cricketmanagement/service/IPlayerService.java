package com.hexaware.cricketmanagement.service;

import com.hexaware.cricketmanagement.entities.Player;
import com.hexaware.cricketmanagement.dto.PlayerDTO;

import java.util.List;

public interface IPlayerService {

    Player addPlayer(PlayerDTO playerDTO);

    PlayerDTO getPlayerById(int playerId);

    List<Player> getAllPlayers();

    Player updatePlayer(int playerId, PlayerDTO playerDTO);

    String deletePlayer(int playerId);
}
