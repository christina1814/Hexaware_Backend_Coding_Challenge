import { Component } from '@angular/core';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-player-delete',
  templateUrl: './delete-player.component.html'
})
export class DeletePlayerComponent {
  playerId: number = 0;
  message: string = '';

  constructor(private service: PlayerService) {}

  deletePlayer() {
    if (!this.playerId) {
      alert('Please enter a valid Player ID.');
      return;
    }

   this.service.deletePlayer(this.playerId).subscribe(
    () => {alert(`Player with ID ${this.playerId} deleted successfully!`);},
    
    () => {
      alert(`Player with ID ${this.playerId} not found`);
    });
  }
}
