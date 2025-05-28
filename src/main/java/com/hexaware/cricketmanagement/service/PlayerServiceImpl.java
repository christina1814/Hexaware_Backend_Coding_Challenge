package com.hexaware.cricketmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketmanagement.dto.PlayerDTO;
import com.hexaware.cricketmanagement.entities.Player;
import com.hexaware.cricketmanagement.exception.ResourceNotFoundException;
import com.hexaware.cricketmanagement.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player addPlayer(PlayerDTO playerDTO) {
        Player player = new Player();

        player.setPlayerId(playerDTO.getPlayerId());
        player.setPlayerName(playerDTO.getPlayerName());
        player.setJerseyNumber(playerDTO.getJerseyNumber());
        player.setRole(playerDTO.getRole());
        player.setTotalMatches(playerDTO.getTotalMatches());
        player.setTeamName(playerDTO.getTeamName());
        player.setCountryOrStateName(playerDTO.getCountryOrStateName());
        player.setDescription(playerDTO.getDescription());

        return playerRepository.save(player);
    }

    @Override
    public PlayerDTO getPlayerById(int playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with ID: " + playerId));

        PlayerDTO dto = new PlayerDTO();
        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setRole(player.getRole());
        dto.setTotalMatches(player.getTotalMatches());
        dto.setTeamName(player.getTeamName());
        dto.setCountryOrStateName(player.getCountryOrStateName());
        dto.setDescription(player.getDescription());

        return dto;
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player updatePlayer(int playerId, PlayerDTO dto) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found with ID: " + playerId));

        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryOrStateName(dto.getCountryOrStateName());
        player.setDescription(dto.getDescription());

        return playerRepository.save(player);
    }

    @Override
    public String deletePlayer(int playerId) {
        if (!playerRepository.existsById(playerId)) {
            throw new ResourceNotFoundException("Player not found with ID: " + playerId);
        }
        playerRepository.deleteById(playerId);
        return "Player deleted successfully with ID: " + playerId;
    }
}
