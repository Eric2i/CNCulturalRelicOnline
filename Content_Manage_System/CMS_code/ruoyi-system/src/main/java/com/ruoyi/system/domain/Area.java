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
 * 场地信息对象 area
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "area", excludeProperty = {"createBy", "updateBy", "updateTime", "remark"})
public class Area extends BaseEntity {
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
     * 地址
     */
    @Excel(name = "地址")
    private String address;

    /**
     * 详情
     */
    @Excel(name = "详情")
    private String detail;

    /**
     * 联系方式
     */
    @Excel(name = "联系方式")
    private String tel;

    /**
     * 图片
     */
    @Excel(name = "图片")
    private String cover;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "开始时间", width = 30, dateFormat = "HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "结束时间", width = 30, dateFormat = "HH:mm:ss")
    private Date endTime;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Integer status;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private Double price;
    @TableField(exist = false)
    private Category category;


}
