package com.hexaware.cricketmanagement.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hexaware.cricketmanagement.dto.PlayerDTO;
import com.hexaware.cricketmanagement.entities.Player;
import com.hexaware.cricketmanagement.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

    @Autowired
    private IPlayerService playerService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Player addPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        return playerService.addPlayer(playerDTO);
    }

    @GetMapping("/{playerId}")
    public PlayerDTO getPlayerById(@PathVariable Long playerId) {
        return playerService.getPlayerById(playerId);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PutMapping(value = "/{playerId}", consumes = "application/json")
    public Player updatePlayer(@PathVariable Long playerId, @Valid @RequestBody PlayerDTO playerDTO) {
        return playerService.updatePlayer(playerId, playerDTO);
    }

    @DeleteMapping("/{playerId}")
    public String deletePlayer(@PathVariable Long playerId) {
        return playerService.deletePlayer(playerId);
    }
}
