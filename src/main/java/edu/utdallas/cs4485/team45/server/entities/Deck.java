package edu.utdallas.cs4485.team45.server.entities;

import java.util.Collections;
import java.util.Stack;

import static edu.utdallas.cs4485.team45.server.entities.Card.Type.*;

public class Deck {

    Stack<Card> cards;

    public Deck() {
        cards = new Stack<>();
        initializeDeck();
    }

    public Deck(int x) {
        cards = new Stack<>();
    }


    public void initializeDeck() {
        // Add all the numbered cards
        for (Card.Color color : Card.Color.values()) {
            if (color != Card.Color.BLACK) {
                for (int num = 0; num <= 9; num++) {
                    cards.add(new Card(color, num));
                }
                for (int num = 1; num <= 9; num++) {
                    cards.add(new Card(color, num));
                }
            }
        }

        // Add special cards
        for (int i = 0; i < 2; i++) {
            for (Card.Color color : Card.Color.values()) {
                if (color != Card.Color.BLACK) {
                    cards.add(new Card(color, SKIP));
                    cards.add(new Card(color, REVERSE));
                    cards.add(new Card(color, DRAW_TWO));
                }
            }
        }

        // Add wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(Card.Color.BLACK, WILD));
            cards.add(new Card(Card.Color.BLACK, WILD_DRAW_FOUR));
        }
        int id=0;
        for(Card card : cards){
            card.id=id;
            id++;
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.pop();
        }
        return null;
    }

    public int size() {
        return cards.size();
    }


}
