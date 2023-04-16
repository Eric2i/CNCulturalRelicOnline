package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章资讯对象 article
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "article", excludeProperty = {"updateBy","updateTime","remark"})
public class Article extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
        @TableId("id")
        private Long id;

    /** 标题 */
    @Excel(name = "标题")
        private String title;

    /** 主图 */
    @Excel(name = "主图")
        private String cover;

    /** 内容 */
    @Excel(name = "内容")
        private String content;

    /** 浏览次数 */
    @Excel(name = "浏览次数")
        private Integer views;


}
