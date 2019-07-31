package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService  userService;
////****************************by the service
    ///localhost:9099/api/all
    @GetMapping("/all")
    public List<User> findAllUsers(){
        return userService.AllUsers();
    }

    ///localhost:9099/api/load/all/{id}

    @GetMapping("/all/{id}")
    public User getUserById(@PathVariable(value = "id") int userId) {

        return  userService.getUserById(userId);
    }
///////******************normal
    ///localhost:9099/api/load
    @PostMapping("/load")
    public List<User> createUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return  userRepository.findAll();
    }

    ///localhost:9099/api/{id}
    @PutMapping("/all/{id}")
    public User updateUser(@PathVariable(value = "id") int userId,
                           @Valid @RequestBody User userDetails)  {

       User user = userRepository.findById(userId).get();

        user.setUserName(userDetails.getUserName());

       User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    ///localhost:9099/api/{id}
    @DeleteMapping("/all/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") int userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

}
