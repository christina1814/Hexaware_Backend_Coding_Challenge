import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { AddPlayerComponent } from './players/add-player/add-player.component';
import { PlayerListComponent } from './players/player-list/player-list.component';
import { UpdatePlayerComponent } from './players/update-player/update-player.component';
import { DeletePlayerComponent } from './players/delete-player/delete-player.component';



@NgModule({
  declarations: [
    AppComponent,
    AddPlayerComponent,
    PlayerListComponent,
    UpdatePlayerComponent,
    DeletePlayerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
