package com.ouc.usedbook.controller;

import com.ouc.usedbook.dto.LoginDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description 用户控制器
 * @date 2020/5/31 21:55
 */
@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class UserController {
    @PostMapping("/login")
    public String login(LoginDTO loginDTO) {
        System.out.println(loginDTO);
        return "success";
    }
}
