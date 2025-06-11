export enum PlayerRole {
  BATSMAN = 'BATSMAN',
  BOWLER = 'BOWLER',
  ALL_ROUNDER = 'ALLROUNDER',
  WICKET_KEEPER = 'KEEPER'
}

export interface Player {
  playerId?: number;
  playerName: string;
  jerseyNumber: number;
  role: PlayerRole;
  totalMatches: number;
  teamName: string;
  countryOrStateName: string;
  description: string;
}
