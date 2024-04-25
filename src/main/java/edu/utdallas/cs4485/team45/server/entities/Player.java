package edu.utdallas.cs4485.team45.server.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String username;
    ArrayList<Card> hand;

    public Player(String username) {
        this.username = username;
        this.hand = new ArrayList<>();
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
