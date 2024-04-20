package edu.utdallas.cs4485.team45.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LobbyController {

    @PostMapping("/lobby/create")
    public String createLobby(@RequestBody LobbyCreationRequest request) {
        // lobby creation logic
    }

    @PostMapping("/lobby/join/{player}")
    public String joinLobby(@PathVariable("player") String player, @RequestBody JoinLobbyRequest request) {
        // lobby join logic
    }

    @PostMapping("/lobby/viewLeaderboard")
    public String viewLeaderboard(@RequestBody ViewLeaderboard request) {
        // view leaderboard logic
    }
}