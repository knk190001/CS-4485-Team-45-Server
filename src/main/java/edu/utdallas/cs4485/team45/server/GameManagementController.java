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
    public String startGame(@RequestBody StartGameRequest request) {
        // game start logic
        gameEngine.addPlayer(request.getUserName());
        return gameEngine.startGame();
    }

    @PostMapping("/game/leave")
    public String leaveGame(@RequestBody LeaveGameRequest request) {
        // game leave logic
    }

    @PostMapping("/game/getGameState")
    public String getGameState(@RequestBody LeaveGameRequest request) {
        // get game state logic
        return gameEngine.makeGameState(); //##
    }

    

    // @GetMapping("/game/{gameId}")
    // public GameInfo getGameInfo(@PathVariable("gameId") String gameId) {
    //     // Your game info retrieval logic here
    // }
}
