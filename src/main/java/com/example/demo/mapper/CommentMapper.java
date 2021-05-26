package com.example.demo.mapper;

import com.example.demo.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.vo.commentVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2021-04-30
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<commentVo> getCommentList(String productId);
}
