package edu.utdallas.cs4485.team45.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameManagementController {

    @PostMapping("/game/start")
    public String startGame(@RequestBody StartGameRequest request) {
        // game start logic
    }

    @PostMapping("/game/leave")
    public String leaveGame(@RequestBody LeaveGameRequest request) {
        // game leave logic
    }

    // @GetMapping("/game/{gameId}")
    // public GameInfo getGameInfo(@PathVariable("gameId") String gameId) {
    //     // Your game info retrieval logic here
    // }
}