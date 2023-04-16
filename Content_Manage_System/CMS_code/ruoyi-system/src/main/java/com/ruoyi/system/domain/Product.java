package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 商品对象 product
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "product", excludeProperty = {"createBy", "updateBy", "updateTime", "remark"})
public class Product extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品表主键id
     */
    @TableId("id")
    private String id;

    /**
     * 商品名
     */
    @Excel(name = "商品名")
    private String name;

    /**
     * 商品主图
     */
    @Excel(name = "商品主图")
    private String cover;

    /**
     * 商品简介
     */
    @Excel(name = "商品简介")
    private String intro;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private Double price;

    /**
     * 商品上架状态（0：下架，1：上架）
     */
    @Excel(name = "商品上架状态", readConverterExp = "0=：下架，1：上架")
    private Integer status;


}
