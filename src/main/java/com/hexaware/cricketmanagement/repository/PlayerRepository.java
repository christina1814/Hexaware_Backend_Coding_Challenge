package com.hexaware.cricketmanagement.repository;

import com.hexaware.cricketmanagement.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> 
{
    boolean existsByJerseyNumber(int jerseyNumber);
}
