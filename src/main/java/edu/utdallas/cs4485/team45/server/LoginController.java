package edu.utdallas.cs4485.team45.server;

import edu.utdallas.cs4485.team45.server.entities.GameEngine;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return "signUpUser";
    }

    @PostMapping("/login/{name}/{pass}")
    public String loginUser(@PathVariable("name") String name, @PathVariable("pass") String pass) {
        // login logic
        return "loginUser";
    }
}
