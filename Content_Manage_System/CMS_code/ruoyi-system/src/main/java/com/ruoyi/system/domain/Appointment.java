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
 * 预约记录对象 appointment
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "appointment", excludeProperty = {"createBy","updateBy","updateTime","remark"})
public class Appointment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
        @TableId("id")
        private Long id;

    /** 项目id */
    @Excel(name = "项目id")
        private Long itemId;

    /** 用户id */
    @Excel(name = "用户id")
        private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
        private String username;

    /** 类型 */
    @Excel(name = "类型")
        private Integer type;

    /** 价格 */
    @Excel(name = "价格")
        private Double price;

    /** 数量 */
    @Excel(name = "数量")
        private Integer num;

    /** 总价 */
    @Excel(name = "总价")
        private Double totalPrice;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
        private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
        private Date endTime;

    /** 支付状态 */
    @Excel(name = "支付状态")
        private Integer status;

    /** 状态 */
    @Excel(name = "状态")
        private Integer status1;


}
