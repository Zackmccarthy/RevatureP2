package com.example.rest;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.exceptions.UserNotFoundException;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public UserRestController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @RequestMapping(
            value = "api/users",
            method = RequestMethod.GET,
            produces = {
                    "application/json"
            }
    )
    public Iterable<User> getUsers() {
        Iterable<User> users = userRepository.findAll();
        return users;
    }

    @RequestMapping(
            value = "api/user/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Optional<User> getUser(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "register",
            consumes = {"application/json"}
    )
    public void registerUser(
            @RequestBody User newUser
    ) {
        userService.register(newUser);
    }

}
