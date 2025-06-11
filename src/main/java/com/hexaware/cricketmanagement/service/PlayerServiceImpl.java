package com.hexaware.cricketmanagement.service;

import com.hexaware.cricketmanagement.dto.PlayerDTO;
import com.hexaware.cricketmanagement.entities.Player;
import com.hexaware.cricketmanagement.exception.PlayerNotFoundException;
import com.hexaware.cricketmanagement.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements IPlayerService
{

    private final PlayerRepository repository;

    public PlayerServiceImpl(PlayerRepository repository) 
    {
        this.repository = repository;
    }

    @Override
    public List<Player> getAllPlayers() 
    {
        return repository.findAll();
    }

    @Override
    public Player getPlayerById(int id) 
    {
        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with ID: " + id));
    }

    @Override
    public Player createPlayer(PlayerDTO dto) 
    {
        if (repository.existsByJerseyNumber(dto.getJerseyNumber())) 
        {
            throw new IllegalArgumentException("Jersey number already in use");
        }
        Player player = new Player();
        copyDtoToEntity(dto, player);
        return repository.save(player);
    }

    @Override
    public Player updatePlayer(int id, PlayerDTO dto) 
    {
        Player player = getPlayerById(id);
        copyDtoToEntity(dto, player);
        return repository.save(player);
    }

    @Override
    public void deletePlayer(int id) 
    {
        if (!repository.existsById(id)) 
        {
            throw new PlayerNotFoundException("Player not found with ID: " + id);
        }
        repository.deleteById(id);
    }

    private void copyDtoToEntity(PlayerDTO dto, Player player) 
    {
        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryOrStateName(dto.getCountryOrStateName());
        player.setDescription(dto.getDescription());
    }
}
