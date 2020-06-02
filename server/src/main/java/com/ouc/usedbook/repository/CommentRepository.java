package com.ouc.usedbook.repository;

import com.ouc.usedbook.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/1 23:12
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    /**
     * 通过书籍的Id查找对于评论
     *
     * @param bid 报价
     * @return {@link ArrayList<Comment>}
     */
    @Query
    public ArrayList<Comment> findByBid(Long bid);
}
