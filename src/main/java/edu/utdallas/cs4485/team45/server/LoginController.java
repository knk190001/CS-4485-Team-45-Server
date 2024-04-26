package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    GameEngine gameEngine;

    @Autowired
    public LoginController(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @PostMapping("/signUp/{name}/{pass}")
    public String signUpUser(@PathVariable("name") String name, @PathVariable("pass") String pass) {
        // signUp logic
    }

    @PostMapping("/login/{name}/{pass}")
    public String loginUser(@PathVariable("name") String name, @PathVariable("pass") String pass) {
        // login logic
    }
}
