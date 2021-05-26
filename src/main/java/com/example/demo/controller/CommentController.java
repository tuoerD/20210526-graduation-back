package com.example.demo.controller;


import com.example.demo.entity.Cart;
import com.example.demo.entity.Comment;
import com.example.demo.entity.User;
import com.example.demo.entity.vo.cartVo;
import com.example.demo.entity.vo.commentVo;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-04-30
 */
@RestController
@RequestMapping("/demo/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 插入新评价
     */
    @PostMapping("newComment")
    public int newComment(Integer userId, String productId, String contentText){
        Comment comment=new Comment();
        comment.setUserId(userId);
        comment.setProductId(productId);
        comment.setContentText(contentText);
        Date date = new Date();
        comment.setTime(date);
        if(commentService.newComment(comment)==false){
            return -1;
        }
        else{
            return 1;
        }
    }

    /**
     * 获取评价列表
     */
    @PostMapping("getCommentList")
    public List<commentVo> getCommentList(String productId){
        return commentService.getCommentList(productId);
    }
}

