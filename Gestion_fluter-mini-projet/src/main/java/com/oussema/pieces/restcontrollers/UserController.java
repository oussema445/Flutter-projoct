package com.oussema.pieces.restcontrollers;

import com.oussema.pieces.entities.User;
import com.oussema.pieces.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Méthode pour enregistrer un utilisateur
    @PostMapping("/register")
    public User Register(@RequestBody User user) {
        return userRepository.save(user);
    }

    
    @PostMapping("/login")
    public User Login(@RequestBody User user) {
        User oldUSer = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return oldUSer;
    }
}
