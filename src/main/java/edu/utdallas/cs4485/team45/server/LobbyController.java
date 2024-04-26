package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LobbyController {

    GameEngine gameEngine;

    @Autowired
    public LobbyController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @PostMapping("/lobby/join/{player}")
    public String joinLobby(@PathVariable("player") String player) {
        gameEngine.addPlayer(request.getUserName());
        return "player" + player + "added";
    }
}
