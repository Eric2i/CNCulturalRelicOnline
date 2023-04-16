package com.ruoyi.system.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CommentMapper;
import com.ruoyi.system.domain.Comment;
import com.ruoyi.system.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 评论信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {
    @Resource
    private CommentMapper commentMapper;

    /**
     * 查询评论信息
     *
     * @param id 评论信息主键
     * @return 评论信息
     */
    public Comment selectCommentById(Long id){
        return commentMapper.selectCommentById(id);
    }

    /**
     * 查询评论信息列表
     *
     * @param comment 评论信息
     * @return 评论信息
     */
    @Override
    public List<Comment> selectCommentList(Comment comment)
    {
        return commentMapper.selectCommentList(comment);
    }

    @Override
    public int deleteBy(Comment comment) {
        return commentMapper.deleteBy(comment);
    }

    @Override
    public Comment getOneBy(Comment comment) {
        return commentMapper.getOneBy(comment);
    }

}
