package edu.utdallas.cs4485.team45.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// adding other classes
import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import edu.utdallas.cs4485.team45.server.entities.GameState;

@RestController
@RequestMapping("/api")
public class GameManagementController {
    private GameEngine gameEngine = new GameEngine();

    @PostMapping("/game/start")
    public GameState startGame(@RequestBody StartGameRequest request) {
        return gameEngine.startGame();
    }

    @PostMapping("/game/getGameState")
    public GameState getGameState(@RequestBody LeaveGameRequest request) {
        return gameEngine.makeGameState(); //##
    }

    

    // @GetMapping("/game/{gameId}")
    // public GameInfo getGameInfo(@PathVariable("gameId") String gameId) {
    //     // Your game info retrieval logic here
    // }
}
