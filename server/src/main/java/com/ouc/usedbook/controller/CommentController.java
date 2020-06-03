package com.ouc.usedbook.controller;

import com.ouc.usedbook.dto.CommentDTO;
import com.ouc.usedbook.entity.Comment;
import com.ouc.usedbook.service.CommentService;
import com.ouc.usedbook.util.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description TODO
 * @date 2020/6/2 10:33
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentController {
    final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ApiOperation(value = "获取留言", notes = "根据二手书的bid获取书籍的留言列表", httpMethod = "GET")
    @GetMapping("/list/{bid}")
    Response list(@PathVariable Long bid){
        ArrayList<Comment> comments = commentService.get(bid);
        return Response.ok(comments);
    }

    @ApiOperation(value = "留言", notes = "根据二手书的bid和用户uid添加留言", httpMethod = "POST")
    @PostMapping("/add")
    Response add(CommentDTO commentDTO){
        long cid = commentService.add(commentDTO.toComment());
        return Response.ok(cid);
    }
}
