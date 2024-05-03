package edu.utdallas.cs4485.team45.server.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String username;
    public ArrayList<Card> hand;
    public String password;
    public int numWins=0;

    public Player(String username) {
        this.username = username;
        this.hand = new ArrayList<>();
    }
    public Player(String username, String password) {
        this.username = username;
        this.password=password;
        this.hand = new ArrayList<>();
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getUsername() {
        return username;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void playCard(int id){
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).getId() == id) {
                hand.remove(i);
                return;
            }
        }
    }

}
