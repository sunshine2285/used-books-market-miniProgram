package com.ouc.usedbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/17 0:58
 */
@Data
@NoArgsConstructor
public class CommentViewDTO {
    String username;
    String college;
    String major;
    String message;
    String date;
}
