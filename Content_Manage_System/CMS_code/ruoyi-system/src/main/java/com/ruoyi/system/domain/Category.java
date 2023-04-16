package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分类对象 category
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "category", excludeProperty = {"createBy","updateBy","updateTime","remark"})
public class Category extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分类id */
        @TableId("id")
        private Long id;

    /** 分类名称 */
    @Excel(name = "分类名称")
        private String categoryName;


}
