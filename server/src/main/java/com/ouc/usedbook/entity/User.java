package com.ouc.usedbook.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/5/31 22:21
 */
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String mail;
    String tel;
    String college;
    String major;
    String year;
}
