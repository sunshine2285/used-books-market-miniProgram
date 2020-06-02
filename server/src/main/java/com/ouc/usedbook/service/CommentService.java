package com.ouc.usedbook.service;

import com.ouc.usedbook.entity.Comment;
import com.ouc.usedbook.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 10:43
 */
@Service
public class CommentService {
    final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * 获取某二手书的所有评论
     *
     * @param bid 二手书id
     * @return {@link ArrayList<Comment>}
     */
    public ArrayList<Comment> get(Long bid){
        return commentRepository.findByBid(bid);
    }

    /**
     * 添加评论，返回成功添加的评论的id
     *
     * @param comment 评论
     * @return long
     */
    public long add(Comment comment){
        return commentRepository.save(comment).getId();
    }
}
