package com.hexaware.cricketmanagement.dto;

import jakarta.validation.constraints.*;

public class PlayerDTO {

    @NotBlank(message = "Player name is required")
    private String playerName;

    @Min(value = 1, message = "Jersey number must be greater than 0")
    private int jerseyNumber;

    @NotBlank(message = "Role is required")
    private String role;

    @Min(value = 0, message = "Total matches cannot be negative")
    private int totalMatches;

    @NotBlank(message = "Team name is required")
    private String teamName;

    @NotBlank(message = "Country/State name is required")
    private String countryOrStateName;

    private String description;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(int totalMatches) {
        this.totalMatches = totalMatches;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCountryOrStateName() {
        return countryOrStateName;
    }

    public void setCountryOrStateName(String countryOrStateName) {
        this.countryOrStateName = countryOrStateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
