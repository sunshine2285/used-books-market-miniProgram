package com.ouc.usedbook.dto;

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
}
