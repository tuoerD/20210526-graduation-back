package com.example.demo.service;

import com.example.demo.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.vo.commentVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author testjava
 * @since 2021-04-30
 */
public interface CommentService extends IService<Comment> {

    Boolean newComment(Comment comment);

    List<commentVo> getCommentList(String productId);
}
