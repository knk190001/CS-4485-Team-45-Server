package edu.utdallas.cs4485.team45.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GamePlayController {

    @PostMapping("/game/playCard")
    public String playCard(@RequestBody PlayCardRequest request) {
        // play card logic
    }

    @PostMapping("/game/drawCard/{count}")
    public String drawCard(@PathVariable("count") int count, @RequestBody DrawCardRequest request) {
        // draw card logic
    }

    @PostMapping("/game/passTurn")
    public String passTurn(@RequestBody PassTurnRequest request) {
        // pass turn logic
    }

    @PostMapping("/game/callUNO")
    public String callUno(@RequestBody CallUNORequest request) {
        // UNO call logic
    }
}