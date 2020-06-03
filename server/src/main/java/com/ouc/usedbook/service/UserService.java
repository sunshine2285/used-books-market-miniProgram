package com.ouc.usedbook.service;

import com.ouc.usedbook.entity.User;
import com.ouc.usedbook.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 12:45
 */
@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> get(Long uid) {
        return userRepository.findById(uid);
    }

    public User add(User user){
        return userRepository.save(user);
    }

    public User login(String mail, String password){
        return userRepository.findByMailAndPassword(mail, password);
    }
}
