package br.com.estagginc.estagg_api.controller;

import br.com.estagginc.estagg_api.model.User;
import br.com.estagginc.estagg_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }


    @GetMapping()
    public List findAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findUserById(@PathVariable(value = "id") Long id){
        return userRepository.findById(id);
    }
}
