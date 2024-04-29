package edu.utdallas.cs4485.team45.server.entities;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    public List<Player> players;
    public Card pile; // top card on pile
    public Player currentPlayer;
    public Player winner = null;
    public int gameStateId;

    public GameState(List<Player> players, Card pile, Player currentPlayer, Player winner, int gameStateId) {
        this.players = players;
        this.pile = pile;
        this.currentPlayer = currentPlayer;
        this.winner = winner;
        this.gameStateId = gameStateId;
    }


}