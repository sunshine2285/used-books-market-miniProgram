package com.ouc.usedbook.dto;

import com.ouc.usedbook.entity.Comment;
import lombok.Data;

import java.sql.Date;

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
    String content;

    public Comment toComment(){
        Comment comment = new Comment();
        comment.setUid(this.uid);
        comment.setBid(this.bid);
        comment.setContent(this.content);
        comment.setDate(new Date(System.currentTimeMillis()));
        return comment;
    }
}
