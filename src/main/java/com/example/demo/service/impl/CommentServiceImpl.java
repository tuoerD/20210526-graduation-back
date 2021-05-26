package com.example.demo.service.impl;

import com.example.demo.entity.Comment;
import com.example.demo.entity.vo.cartVo;
import com.example.demo.entity.vo.commentVo;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-04-30
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 新建评价
     * @param comment
     * @return
     */
    @Override
    public Boolean newComment(Comment comment) {
        baseMapper.insert(comment);
        return true;
    }

    /**
     * 获取评价列表
     */
    @Override
    public List<commentVo> getCommentList(String productId) {
        List<commentVo> list =  commentMapper.getCommentList(productId);
        return list;
    }
}
