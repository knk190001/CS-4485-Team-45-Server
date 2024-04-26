package edu.utdallas.cs4485.team45.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LobbyController {

    @PostMapping("/lobby/join/{player}")
    public String joinLobby(@PathVariable("player") String player, @RequestBody JoinLobbyRequest request) {
        gameEngine.addPlayer(request.getUserName());
        return "player" + player + "added";
    }
}
