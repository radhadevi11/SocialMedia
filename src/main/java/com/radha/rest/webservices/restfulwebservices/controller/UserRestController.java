package com.radha.rest.webservices.restfulwebservices.controller;

import com.radha.rest.webservices.restfulwebservices.app.entities.UserEntity;
import com.radha.rest.webservices.restfulwebservices.app.service.NoSuchUserException;
import com.radha.rest.webservices.restfulwebservices.app.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    private UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<UserEntity> getAllUsers () {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public UserEntity getUser (@PathVariable int id) throws NoSuchUserException {
        return userService.getUSer(id);
    }

    @PostMapping (consumes = "application/json", produces = "application/json")
    public void save (@RequestBody UserEntity userEntity) {
        ResponseEntity.created(null);
    }

    @DeleteMapping (path = "/users/{id}")
    public void deleteUser (@PathVariable int id) throws NoSuchUserException {
        userService.deleteUser(id);
    }
}
