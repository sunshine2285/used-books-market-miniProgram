package com.ouc.usedbook.dto;

import com.ouc.usedbook.entity.User;
import lombok.Data;

/**
 * 注册dto
 *
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 9:13
 */
@Data
public class RegisterDTO {
    String username;
    String password;
    String mail;
    String tel;
    String college;
    String major;
    String year;

    public User toUser(){
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setMail(this.mail);
        user.setTel(this.tel);
        user.setCollege(this.college);
        user.setMajor(this.major);
        user.setYear(this.year);
        return user;
    }

}
