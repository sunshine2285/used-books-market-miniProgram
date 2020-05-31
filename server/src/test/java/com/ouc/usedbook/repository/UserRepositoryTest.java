package com.ouc.usedbook.repository;

import com.ouc.usedbook.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/5/31 22:30
 */
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void select() {
        System.out.println(userRepository.findAll());
    }

    @Test
    void save() {
        User user = new User();
        user.setUsername("xiaoxiao");
        user.setPassword("123456");
        user.setTel("17686523750");
        user.setCollege("信息学院");
        user.setMajor("计算机");
        user.setYear("2018");
        System.out.println(userRepository.save(user));
    }
}
