package edu.utdallas.cs4485.team45.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// adding other classes
import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import edu.utdallas.cs4485.team45.server.entities.GameState;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GameManagementController {
    GameEngine gameEngine;

    @Autowired
    public GameManagementController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @PostMapping("/game/start")
    public GameState startGame() {
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
