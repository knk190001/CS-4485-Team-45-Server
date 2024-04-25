package edu.utdallas.cs4485.team45.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// adding the classes used?
import edu.utdallas.cs4485.team45.server.entities.Card;
import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import edu.utdallas.cs4485.team45.server.entities.GameState; 

@RestController
@RequestMapping("/api")
public class GamePlayController {
    private GameEngine gameEngine = new GameEngine();

    // card colors: red, blue, green, yellow, black 
    // ##
    // add player, add lobby, start game, play card, draw card
    // add get game state function
    @PostMapping("/game/playCard/{id}")
    public String playCard(@PathVariable("id") int id, @RequestBody PlayCardRequest request) {
        // play card logic
        Card.Color colorToChangeTo = request.getColorToChangeTo();
        return gameEngine.playCard(id, colorToChangeTo);
    }

    @PostMapping("/game/drawCard")
    public String drawCard(@RequestBody DrawCardRequest request) {
        // draw card logic
        return gameEngine.drawCard();   
    }

    @PostMapping("/game/passTurn")
    public String passTurn(@RequestBody PassTurnRequest request) {
        // pass turn logic
        gameEngine.switchToNextPlayer();
        return gameEngine.makeGameState();
    }

    @PostMapping("/game/callUNO")
    public String callUno(@RequestBody CallUNORequest request) {
        // UNO call logic
    }
}
