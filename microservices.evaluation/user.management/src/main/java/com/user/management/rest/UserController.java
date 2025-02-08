package com.user.management.rest;

import com.user.management.core.UserService;
import com.user.management.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/managements/users")
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

}
