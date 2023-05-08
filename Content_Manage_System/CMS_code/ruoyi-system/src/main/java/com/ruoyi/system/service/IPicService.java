package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Pic;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 图片信息Service接口
 *
 * @author ruoyi
 * @date 2023-05-07
 */
public interface IPicService extends IService<Pic>{

    /**
     * 查询图片信息
     *
     * @param id 图片信息主键
     * @return 图片信息
     */
    public Pic selectPicById(Long id);

    /**
     * 查询图片信息列表
     *
     * @param pic 图片信息
     * @return 图片信息集合
     */
    public List<Pic> selectPicList(Pic pic);

    int deleteBy(Pic pic);

    Pic getOneBy(Pic pic);
}
