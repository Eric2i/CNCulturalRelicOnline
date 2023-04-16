package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 评论信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 查询评论信息
     *
     * @param id 评论信息主键
     * @return 评论信息
     */
    public Comment selectCommentById(Long id);

    /**
     * 查询评论信息列表
     *
     * @param comment 评论信息
     * @return 评论信息集合
     */
    public List<Comment> selectCommentList(Comment comment);


    int deleteBy(Comment comment);

    Comment getOneBy(Comment comment);

}
