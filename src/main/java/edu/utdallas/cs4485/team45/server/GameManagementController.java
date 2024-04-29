package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import edu.utdallas.cs4485.team45.server.entities.GameEvent;
import edu.utdallas.cs4485.team45.server.entities.GameState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameManagementController {
    GameEngine gameEngine;
    GameEventController eventController;

    @Autowired
    public GameManagementController(GameEngine gameEngine, GameEventController eventController) {
        this.gameEngine = gameEngine;
        this.eventController = eventController;
    }

    @PostMapping("/game/start")
    public GameState startGame() {
        eventController.emitEvent(GameEvent.START);
        return gameEngine.startGame();
    }

    @PostMapping("/game/getGameState")
    public GameState getGameState() {
        return gameEngine.makeGameState(); //##
    }

    

    // @GetMapping("/game/{gameId}")
    // public GameInfo getGameInfo(@PathVariable("gameId") String gameId) {
    //     // Your game info retrieval logic here
    // }
}
