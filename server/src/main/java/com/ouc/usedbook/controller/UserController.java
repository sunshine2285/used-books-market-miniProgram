package com.ouc.usedbook.controller;

import com.ouc.usedbook.dto.LoginDTO;
import com.ouc.usedbook.dto.RegisterDTO;
import com.ouc.usedbook.entity.User;
import com.ouc.usedbook.service.UserService;
import com.ouc.usedbook.util.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description 用户控制器
 * @date 2020/5/31 21:55
 */
@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "用户登录", notes = "用户通过账号和密码登录", httpMethod = "POST")
    @PostMapping("/login")
    public Response login(LoginDTO loginDTO) {
        User user = userService.login(loginDTO.getMail(), loginDTO.getPassword());
        if (null == user) {
            return Response.forbidden(null);
        } else {
            return Response.ok(user);
        }
    }

    @ApiOperation(value = "用户注册", notes = "用户通过用户信息注册账号", httpMethod = "POST")
    @PostMapping("/register")
    public Response register(RegisterDTO registerDTO) {
        User user = userService.add(registerDTO.toUser());
        if (null == user){
            return Response.forbidden("wrong info about register");
        }else{
            return Response.ok(user);
        }
    }

    @ApiOperation(value = "用户信息", notes = "根据用户id获取用户相关信息", httpMethod = "GET")
    @GetMapping("/{uid}")
    public Response userInfo(@PathVariable Long uid) {
        Optional<User> user = userService.get(uid);
        return user.map(Response::ok).orElseGet(() -> Response.notfound(uid));
    }
}
