package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void register(User user) {
        User userInDatabase = userRepository.findByUsername(user.getUsername());
        if (userInDatabase != null) {
            throw new IllegalStateException("User already exists");
        }

//        user.setUsername(user.getUsername());
//        user.setPassword(user.getPassword());
//        user.setName(user.getName());
//
//
//        userRepository.save(user);

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        Role role = new Role();
        role.setId(1);
        List<Role> roles = List.of(role);
        newUser.setRoles(roles);

        userRepository.save(newUser);

    }
}
