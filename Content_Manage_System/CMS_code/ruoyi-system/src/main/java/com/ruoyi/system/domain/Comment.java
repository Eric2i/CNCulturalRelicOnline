package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论信息对象 comment
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "comment", excludeProperty = {"createBy","createTime","updateBy","updateTime","remark"})
public class Comment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
        @TableId("id")
        private Long id;

    /** 项目ID */
    @Excel(name = "项目ID")
        private Long itemId;

    /** 类型 */
    @Excel(name = "类型")
        private Integer type;

    /** 评论用户ID */
    @Excel(name = "评论用户ID")
        private Long commentUserId;

    /** 评论用户 */
    @Excel(name = "评论用户")
        private String commentUserNickName;

    /** 评论用户头像 */
    @Excel(name = "评论用户头像")
        private String commentUserAvatar;

    /** 被评论用户ID */
    @Excel(name = "被评论用户ID")
        private Long targetUserId;

    /** 被评论用户 */
    @Excel(name = "被评论用户")
        private String targetUserNickName;

    /** 被评论用户头像 */
    @Excel(name = "被评论用户头像")
        private String targetUserAvatar;

    /** 评论内容 */
    @Excel(name = "评论内容")
        private String content;

    /** 评论时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "评论时间", width = 30, dateFormat = "yyyy-MM-dd")
        private Date createDate;

    /** 是否精选 */
    @Excel(name = "是否精选")
        private Integer recommend;


}
