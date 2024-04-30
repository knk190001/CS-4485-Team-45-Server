package edu.utdallas.cs4485.team45.server.entities;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GameEngine {

    static ArrayList<Player> lobby = new ArrayList<>(); // this is static so there is only 1
    Deck deck;
    Deck discard;
    Card pile;
    Player currentPlayer;
    boolean reverseDirection = false;
    Player winner=null;
    static int gameStateId=0;

    ArrayList<ActionRecord> actions;

    public void addPlayer(String userName) {
        Player player = new Player(userName);
        lobby.add(player);
    }

    public GameState startGame() {
        deck = new Deck();
        discard = new Deck(1);
        deck.initializeDeck();
        deck.shuffle();
        dealCards();
        pile = deck.drawCard();
        currentPlayer = lobby.get(0);
        winner = null;
        actions = new ArrayList<ActionRecord>();
        return makeGameState();
    }

    public void reset() {
        deck = null;
        discard = null;
        pile = null;
        currentPlayer = null;
        reverseDirection = false;
        winner = null;
        gameStateId=0;
        lobby.clear();
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
        int skipped = (currentIndex + (reverseDirection ? -1 : 1) + lobby.size()) % lobby.size();
        actions.add(new ActionRecord(currentPlayer.username, lobby.get(skipped).username, Action.SKIPPED, pile));
        currentPlayer = lobby.get(nextIndex);
    }

    public GameState playCard(int id, Card.Color colorToChangeTo){ // add special cards
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
                actions.add(new ActionRecord(currentPlayer.username,"", Action.PLAYED, playedCard));
                break;
            case SKIP:
                skipNextPlayer();
                break;
            case WILD:
                switchToNextPlayer();
                pile = new Card(colorToChangeTo, 99);
                actions.add(new ActionRecord(currentPlayer.username,"", Action.WILD, pile));
                break;
            case REVERSE:
                reverseDirection = !reverseDirection; // flip direction
                switchToNextPlayer();
                actions.add(new ActionRecord(currentPlayer.username,"", Action.REVERSED, playedCard));
                break;
            case DRAW_TWO:
                String currentPlayerName = currentPlayer.username;
                switchToNextPlayer();
                actions.add(new ActionRecord(currentPlayerName, currentPlayer.username, Action.DRAW_TWO, playedCard));
                drawCard(false);
                drawCard(false);
                switchToNextPlayer();
                break;
            /*case WILD_DRAW_FOUR:
                switchToNextPlayer();
                drawCard();
                drawCard();
                drawCard();
                drawCard();
                switchToNextPlayer();
                pile = new Card(colorToChangeTo, 99);
                break;*/
        }
        return makeGameState();
    }

    public GameState drawCard(boolean nextPlayer){
        currentPlayer.hand.add(deck.drawCard());
        if(deck.size()==0){ // if deck runs out of cards
            discard.shuffle();
            deck = discard;
            discard = new Deck(1);
        }
        if(nextPlayer){
            switchToNextPlayer();
            actions.add(new ActionRecord(currentPlayer.username,"", Action.DREW, null));
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

    public GameState makeGameState(){
        gameStateId++;
        GameState gameState = new GameState(lobby, pile, currentPlayer, winner, gameStateId, actions);
        return gameState;
    }

}
