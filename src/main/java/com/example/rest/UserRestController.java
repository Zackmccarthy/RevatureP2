package com.example.rest;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        if (user.isPresent()) {
            return user;
        }
        return user;
    }
}
