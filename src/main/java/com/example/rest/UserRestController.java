package com.example.rest;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.exceptions.UserNotFoundException;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(
            value = "api/user/{id}",
            method = RequestMethod.GET,
            produces = {
                    "application/JSON"
            }
    )
    public Optional<User> getUser(@PathVariable("id") int id) {
        Optional<User> user = userRepository.findById(id);
        return null;
    }




}
