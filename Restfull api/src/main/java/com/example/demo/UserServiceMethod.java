package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceMethod implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User getUserById(int userId) {
        User user = userRepository.findById(userId).get();
        return user ;
    }

    @Transactional
    @Override
    public List<User> AllUsers() {
        return userRepository.findAll();
    }


}
