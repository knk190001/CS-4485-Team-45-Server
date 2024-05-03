package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import edu.utdallas.cs4485.team45.server.entities.GameEvent;
import edu.utdallas.cs4485.team45.server.entities.GameState;
import edu.utdallas.cs4485.team45.server.entities.Wins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class GameManagementController {
    GameEngine gameEngine;
    GameEventController eventController;
    Wins gameWins;

    @Autowired
    public GameManagementController(GameEngine gameEngine, GameEventController eventController, Wins gameWins) {
        this.gameEngine = gameEngine;
        this.eventController = eventController;
        this.gameWins = gameWins;
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

    @PostMapping("/game/reset")
    public void resetGame() {
        eventController.emitEvent(GameEvent.RESET);
        gameWins.takeWins(gameEngine.lobby); // wins
        gameEngine.reset();
        eventController.clear();
    }

    @PostMapping("/game/getWins")
    public HashMap getWins() {
        return gameWins.getWins(); // wins
    }


    // @GetMapping("/game/{gameId}")
    // public GameInfo getGameInfo(@PathVariable("gameId") String gameId) {
    //     // Your game info retrieval logic here
    // }
}
