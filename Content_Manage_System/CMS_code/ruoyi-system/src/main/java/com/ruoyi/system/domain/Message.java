package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 留言信息对象 message
 *
 * @author ruoyi
 * @date 2023-05-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "message", excludeProperty = {"createBy","updateBy","updateTime","remark"})
public class Message extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
        @TableId("id")
        private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
        private String name;

    /** 联系方式 */
    @Excel(name = "联系方式")
        private String phone;

    /** 内容 */
    @Excel(name = "内容")
        private String content;

    /** 审核状态 */
    @Excel(name = "审核状态")
        private Integer status;


}
