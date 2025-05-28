package com.hexaware.cricketmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.cricketmanagement.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{}