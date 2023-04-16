package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 器材信息对象 equipment
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "equipment", excludeProperty = {"createBy", "updateBy", "updateTime", "remark"})
public class Equipment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId("id")
    private Long id;

    /**
     * 名称
     */
    @Excel(name = "名称")
    private String name;

    /**
     * 分类id
     */
    @Excel(name = "分类id")
    private Long categoryId;

    /**
     * 详情
     */
    @Excel(name = "详情")
    private String detail;

    /**
     * 图片
     */
    @Excel(name = "图片")
    private String cover;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private Double price;

    /**
     * 数量
     */
    @Excel(name = "数量")
    private Integer num;

    /**
     * 已用数量
     */
    @Excel(name = "已用数量")
    private Integer num1;

    @TableField(exist = false)
    private Category category;


}
