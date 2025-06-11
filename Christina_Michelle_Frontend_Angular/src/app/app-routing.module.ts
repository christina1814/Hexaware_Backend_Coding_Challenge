import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPlayerComponent } from './players/add-player/add-player.component';
import { PlayerListComponent } from './players/player-list/player-list.component';
import { UpdatePlayerComponent } from './players/update-player/update-player.component';
import { DeletePlayerComponent } from './players/delete-player/delete-player.component';

const routes: Routes = [
  { path: '', component: PlayerListComponent }, // Can be HomeComponent if needed
  { path: 'add-player', component: AddPlayerComponent },
  { path: 'players', component: PlayerListComponent },
  { path: 'update-player', component: UpdatePlayerComponent },
  { path: 'delete-player', component: DeletePlayerComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
