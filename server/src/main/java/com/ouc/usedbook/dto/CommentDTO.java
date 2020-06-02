package com.ouc.usedbook.dto;

import lombok.Data;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 10:39
 */
@Data
public class CommentDTO {
    Long uid;
    Long bid;
    String comment;
}
