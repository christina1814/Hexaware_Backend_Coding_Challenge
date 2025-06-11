import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PlayerService } from 'src/app/services/player.service';
import { Player, PlayerRole } from 'src/app/player.model';

@Component({
  selector: 'app-update-player',
  templateUrl: './update-player.component.html'
})
export class UpdatePlayerComponent implements OnInit {

  players: Player[] = [];
  selectedPlayerId: number = 0;

  player: Player = {
    playerId: 0,
    playerName: '',
    jerseyNumber: 0,
    role: PlayerRole.BATSMAN,
    totalMatches: 0,
    teamName: '',
    countryOrStateName: '',
    description: ''
  };

  PlayerRole = PlayerRole;

  constructor(private playerService: PlayerService, private router: Router) {}

  ngOnInit() {
  this.playerService.getAllPlayers()
    .subscribe(
      (data) => { this.players = data; },
      () => { alert("Could not load players"); }
    );
}

onPlayerSelect() {
  if (this.selectedPlayerId == 0) return;

  this.playerService.getPlayerById(this.selectedPlayerId)
    .subscribe(
      (data) => { this.player = data; },
      () => { alert("Player not found"); }
    );
}

updatePlayer() {
  if (!this.player.playerId) {
    alert("Player ID is missing.");
    return;
  }

  this.playerService.updatePlayer(this.player.playerId, this.player)
    .subscribe(
      () => {
        alert("Player updated successfully");
        this.router.navigate(['/players']);
      },
      () => {alert("Update failed");}
    );
}
}
