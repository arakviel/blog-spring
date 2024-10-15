package com.arakviel.eventlistenerdemo.controller;

import com.arakviel.eventlistenerdemo.dto.CreateUserRequest;
import com.arakviel.eventlistenerdemo.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    private String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @GetMapping("/signup")
    private String create() {
        return "users/signup";
    }

    @PostMapping("/signup")
    private String store(@Valid CreateUserRequest createUserRequest, Model model) {
        userService.save(createUserRequest);
        return "redirect:/users?success";
    }
}
