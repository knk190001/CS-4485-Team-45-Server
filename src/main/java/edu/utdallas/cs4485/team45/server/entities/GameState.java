package edu.utdallas.cs4485.team45.server.entities;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    public List<Player> players;
    public Card pile; // top card on pile
    public Player currentPlayer;
    public Player winner = null;
    public int gameStateId;
    public ArrayList<ActionRecord> actions;

    public GameState(List<Player> players, Card pile, Player currentPlayer, Player winner, int gameStateId, ArrayList<ActionRecord> actions) {
        this.players = players;
        this.pile = pile;
        this.currentPlayer = currentPlayer;
        this.winner = winner;
        this.gameStateId = gameStateId;
        this.actions = actions;
    }


}