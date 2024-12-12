package com.coderscampus.assignment14.web;

import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class WelcomeController {
    private final UserService userService;

    public WelcomeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> payload) {
        String name = payload.get("name");
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name cannot be empty.");
        }

        User user = userService.registerOrGetUser(name);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }


    @GetMapping("/")
    public String redirectToWelcome() {
        return "redirect:/welcome";
    }
}