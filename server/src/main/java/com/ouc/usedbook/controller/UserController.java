package com.ouc.usedbook.controller;

import com.ouc.usedbook.dto.LoginDTO;
import com.ouc.usedbook.dto.RegisterDTO;
import com.ouc.usedbook.util.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "用户登录", notes = "用户通过账号和密码登录", httpMethod = "POST")
    @PostMapping("/login")
    public Response login(LoginDTO loginDTO) {
        //check username and password
        //verify ok return user
        //else return forbidden
        return Response.ok(null);
    }

    @ApiOperation(value = "用户注册", notes = "用户通过用户信息注册账号", httpMethod = "POST")
    @PostMapping("/register")
    public Response register(RegisterDTO registerDTO) {
        return Response.ok(null);
    }

    @ApiOperation(value = "用户信息", notes = "根据用户id获取用户相关信息", httpMethod = "GET")
    @GetMapping("/{id}")
    public Response userInfo(@PathVariable int id) {
        return Response.ok(null);
    }
}
