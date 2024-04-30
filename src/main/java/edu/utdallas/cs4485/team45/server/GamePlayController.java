package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.entities.Card;
import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import edu.utdallas.cs4485.team45.server.entities.GameEvent;
import edu.utdallas.cs4485.team45.server.entities.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GamePlayController {
    GameEngine gameEngine;
    GameEventController eventController;

    @Autowired
    public GamePlayController(GameEngine gameEngine, GameEventController eventController) {
        this.gameEngine = gameEngine;
        this.eventController = eventController;
    }

    // card colors: red, blue, green, yellow, black 
    // ##
    // add player, add lobby, start game, play card, draw card
    // add get game state function
    @PostMapping("/game/playCard/{id}")
    public GameState playCard(@PathVariable("id") int id) {
        GameState gameState = gameEngine.playCard(id, null);
        eventController.emitEvent(GameEvent.UPDATE);
        return gameState;
    }

    @PostMapping("/game/playCard/{id}/{color}")
    public GameState playCard(@PathVariable("id") int id, @PathVariable("color") String color) {
        Card.Color colorToChangeTo = Card.Color.BLACK;
        switch(color) {
            case "red":
                colorToChangeTo = Card.Color.RED;
                break;
            case "blue":
                colorToChangeTo = Card.Color.BLUE;
                break;
            case "green":
                colorToChangeTo = Card.Color.GREEN;
                break;
            case "yellow":
                colorToChangeTo = Card.Color.YELLOW;
                break;
        }
        GameState gameState = gameEngine.playCard(id, colorToChangeTo);
        eventController.emitEvent(GameEvent.UPDATE);
        return gameState;
    }

    @PostMapping("/game/drawCard")
    public GameState drawCard() {
        GameState gameState = gameEngine.drawCard(true);
        eventController.emitEvent(GameEvent.UPDATE);
        return gameState;
    }
}
