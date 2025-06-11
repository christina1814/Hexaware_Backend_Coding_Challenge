import { Component } from '@angular/core';
import { Player } from 'src/app/player.model';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-list',
  templateUrl: './player-list.component.html'
})
export class PlayerListComponent {
  players: Player[] = [];
  searchId: number = 0;
  errorMessage: string = '';

  constructor(private service: PlayerService) {}

  ngOnInit() {
  }

  getAllPlayers() {
  this.service.getAllPlayers()
  .subscribe(
    (data) => {this.players = data;},

    () => {
      alert('Unable to fetch players.');
      this.players = [];
    }
  );
}

searchById() {
  if (this.searchId <= 0) {
    alert('Enter a valid player ID.');
    this.players = [];
    return;
  }

  this.service.getPlayerById(this.searchId)
  .subscribe(
    (player) => {this.players = [player];},

    () => {
      alert(`Player with ID ${this.searchId} not found.`);
      this.players = [];
    }
  );
}

}
