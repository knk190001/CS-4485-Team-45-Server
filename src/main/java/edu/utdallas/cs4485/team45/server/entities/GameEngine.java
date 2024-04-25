package edu.utdallas.cs4485.team45.server.entities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class GameEngine {

    static ArrayList<Player> lobby = new ArrayList<>(); // this is static so there is only 1
    Deck deck;
    Deck discard;
    Card pile;
    Player currentPlayer;
    boolean reverseDirection = false;
    Player winner=null;
    static int gameStateId=0;

    void addPlayer(String userName) {
        Player player = new Player(userName);
        lobby.add(player);
    }

    GameState startGame() {
        deck = new Deck();
        discard = new Deck(1);
        deck.initializeDeck();
        deck.shuffle();
        dealCards();
        currentPlayer = lobby.get(0);
        winner = null;
        return makeGameState();
    }

    void dealCards() {
        for (Player player : lobby) {
            for (int i = 0; i < 7; i++) {
                player.addToHand(deck.drawCard());
            }
        }
    }


    void switchToNextPlayer() {
        int currentIndex = lobby.indexOf(currentPlayer);
        int nextIndex;
        if (reverseDirection) {
            nextIndex = (currentIndex - 1 + lobby.size()) % lobby.size();
        } else {
            nextIndex = (currentIndex + 1) % lobby.size();
        }
        currentPlayer = lobby.get(nextIndex);
    }

    void skipNextPlayer() {
        int currentIndex = lobby.indexOf(currentPlayer);
        int nextIndex;
        if (reverseDirection) {
            nextIndex = (currentIndex - 2 + lobby.size()) % lobby.size();
        } else {
            nextIndex = (currentIndex + 2) % lobby.size();
        }
        currentPlayer = lobby.get(nextIndex);
    }

    GameState playCard(int id, Card.Color colorToChangeTo){ // add special cards
        Card playedCard = findCard(id);
        currentPlayer.playCard(id);
        pile=playedCard;
        discard.cards.add(playedCard);
        if(currentPlayer.hand.size()==0){
            winner = currentPlayer;
            return makeGameState();
        }
        switch(playedCard.getType()){
            case NUM:
                switchToNextPlayer();
                break;
            case SKIP:
                skipNextPlayer();
                break;
            case WILD:
                switchToNextPlayer();
                pile = new Card(colorToChangeTo, 99);
                break;
            case REVERSE:
                reverseDirection = !reverseDirection; // flip direction
                switchToNextPlayer();
                break;
            case DRAW_TWO:
                switchToNextPlayer();
                drawCard();
                drawCard();
                switchToNextPlayer();
                break;
            case WILD_DRAW_FOUR:
                switchToNextPlayer();
                drawCard();
                drawCard();
                drawCard();
                drawCard();
                switchToNextPlayer();
                pile = new Card(colorToChangeTo, 99);
                break;
        }
        return makeGameState();
    }

    GameState drawCard(){
        currentPlayer.hand.add(deck.drawCard());
        if(deck.size()==0){ // if deck runs out of cards
            discard.shuffle();
            deck = discard;
            discard = new Deck(1);
        }
        return makeGameState();
    }

    Card findCard(int cardID){
        for(Player player : lobby){
            for(Card card : player.hand){
                if(card.id == cardID){
                    return card;
                }
            }
        }
        return null;
    }

    GameState makeGameState(){
        gameStateId++;
        GameState gameState = new GameState(lobby, pile, currentPlayer, winner, gameStateId);
        return gameState;
    }

}
