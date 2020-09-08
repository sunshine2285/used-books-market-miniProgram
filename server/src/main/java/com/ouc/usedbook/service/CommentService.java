package com.ouc.usedbook.service;

import com.ouc.usedbook.dto.CommentViewDTO;
import com.ouc.usedbook.entity.Comment;
import com.ouc.usedbook.entity.User;
import com.ouc.usedbook.repository.CommentRepository;
import com.ouc.usedbook.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 10:43
 */
@Service
public class CommentService {
    final CommentRepository commentRepository;
    final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    /**
     * 获取某二手书的所有评论
     *
     * @param bid 二手书id
     * @return {@link ArrayList<Comment>}
     */
    public ArrayList<CommentViewDTO> get(Long bid){
        ArrayList<Comment> comments = commentRepository.findByBid(bid);
        ArrayList<CommentViewDTO> commentViewDTOS = new ArrayList<>();
        for (Comment comment : comments) {
            CommentViewDTO commentViewDTO = new CommentViewDTO();
            commentViewDTO.setMessage(comment.getContent());
            commentViewDTO.setDate(comment.getDate().toString());
            Optional<User> user = userRepository.findById(comment.getUid());
            user.ifPresent(presentUser -> {
                commentViewDTO.setUsername(presentUser.getUsername());
                commentViewDTO.setCollege(presentUser.getCollege());
                commentViewDTO.setMajor(presentUser.getMajor());
            });
            commentViewDTOS.add(commentViewDTO);
        }
        return commentViewDTOS;
    }

    /**
     * 添加评论，返回成功添加的评论的id
     *
     * @param comment 评论
     * @return long
     */
    public long add(Comment comment){
        comment.setDate(new Date(System.currentTimeMillis()));
        return commentRepository.save(comment).getId();
    }
}
