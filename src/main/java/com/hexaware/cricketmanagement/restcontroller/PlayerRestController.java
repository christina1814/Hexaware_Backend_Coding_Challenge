package com.hexaware.cricketmanagement.restcontroller;

import com.hexaware.cricketmanagement.dto.PlayerDTO;
import com.hexaware.cricketmanagement.entities.Player;
import com.hexaware.cricketmanagement.service.IPlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")  // Angular integration
@RestController
@RequestMapping("/api/players")
public class PlayerRestController 
{

    private final IPlayerService playerService;

    public PlayerRestController(IPlayerService playerService) 
    {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() 
    {
        return playerService.getAllPlayers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@Valid @RequestBody PlayerDTO dto) 
    {
        return playerService.createPlayer(dto);
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable int id)
    {
        return playerService.getPlayerById(id);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable int id, @Valid @RequestBody PlayerDTO dto)
    {
        return playerService.updatePlayer(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable int id) 
    {
        playerService.deletePlayer(id);
    }
}
