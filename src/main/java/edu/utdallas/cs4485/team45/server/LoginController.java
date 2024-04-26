package edu.utdallas.cs4485.team45.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/signUp/{name}/{pass}")
    public String signUpUser(@PathVariable("name") String name, @PathVariable("pass") String pass) {
        // signUp logic
    }

    @PostMapping("/login/{name}/{pass}")
    public String loginUser(@PathVariable("name") String name, @PathVariable("pass") String pass) {
        // login logic
    }
}
