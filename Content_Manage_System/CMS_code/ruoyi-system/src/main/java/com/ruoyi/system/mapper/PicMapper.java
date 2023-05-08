package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Pic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 图片信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-05-07
 */
public interface PicMapper extends BaseMapper<Pic> {

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
