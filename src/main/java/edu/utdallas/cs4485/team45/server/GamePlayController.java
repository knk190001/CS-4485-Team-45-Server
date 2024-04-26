package edu.utdallas.cs4485.team45.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.*;
// adding the classes used?
import edu.utdallas.cs4485.team45.server.entities.Card;
import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import edu.utdallas.cs4485.team45.server.entities.GameState; 

@RestController
@RequestMapping("/api")
public class GamePlayController {
    GameEngine gameEngine;

    @Autowired
    public GamePlayController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    // card colors: red, blue, green, yellow, black 
    // ##
    // add player, add lobby, start game, play card, draw card
    // add get game state function
    @PostMapping("/game/playCard/{id}")
    public GameState playCard(@PathVariable("id") int id) {
        return gameEngine.playCard(id, null);
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
        return gameEngine.playCard(id, colorToChangeTo);
    }

    @PostMapping("/game/drawCard")
    public GameState drawCard() {
        return gameEngine.drawCard();   
    }

    
}
