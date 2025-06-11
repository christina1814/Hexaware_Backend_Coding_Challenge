// src/app/components/add-player/add-player.component.ts

import { Component } from '@angular/core';
import { Player, PlayerRole } from 'src/app/player.model';
import { PlayerService } from 'src/app/services/player.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent {

  player: Player = {
    playerName: '',
    jerseyNumber: 0,
    role: PlayerRole.BATSMAN,
    totalMatches: 0,
    teamName: '',
    countryOrStateName: '',
    description: ''
  };

  roles = Object.values(PlayerRole); 

  constructor(private playerService: PlayerService, private router: Router) {}

  savePlayer(formValue: any) {
  this.playerService.addPlayer(formValue)
  .subscribe(
    () => {
      alert('Player added successfully!');
      this.router.navigate(['/players']);
    },

    () => {alert('Failed to add player.');}
  );
}

}
