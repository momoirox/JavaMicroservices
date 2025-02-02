package com.user.evaluation.controllers;

import com.user.evaluation.core.UserService;
import com.user.evaluation.dto.UserEvaluationModel;
import com.user.evaluation.dto.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserModel> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public UserModel save(@RequestBody UserModel request) {
        return userService.save(request);
    }

    @GetMapping("/{id}")
    public UserModel get(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping("/evaluations/{id}")
    public UserEvaluationModel getEvaluations(@PathVariable Long id) {
        return userService.getEvaluations(id);
    }
}
