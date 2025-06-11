package com.hexaware.cricketmanagement.service;

import com.hexaware.cricketmanagement.dto.PlayerDTO;
import com.hexaware.cricketmanagement.entities.Player;

import java.util.List;

public interface IPlayerService 
{
    List<Player> getAllPlayers();
    Player getPlayerById(int id);
    Player createPlayer(PlayerDTO dto);
    Player updatePlayer(int id, PlayerDTO dto);
    void deletePlayer(int id);
}
