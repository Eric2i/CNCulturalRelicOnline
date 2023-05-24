package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.annotation.*;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频信息对象 video
 *
 * @author ruoyi
 * @date 2023-05-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "video", excludeProperty = {"createBy","updateBy","updateTime","remark"})
public class Video extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
        @TableId("id")
        private Long id;

    /** 视频 */
    @Excel(name = "视频")
        private String content;

    /** 审核状态 */
    @Excel(name = "审核状态")
        private Integer status;


}
