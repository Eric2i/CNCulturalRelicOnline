package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PicMapper;
import com.ruoyi.system.domain.Pic;
import com.ruoyi.system.service.IPicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 图片信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-07
 */
@Service
public class PicServiceImpl extends ServiceImpl<PicMapper, Pic> implements IPicService {
    @Resource
    private PicMapper picMapper;

    /**
     * 查询图片信息
     *
     * @param id 图片信息主键
     * @return 图片信息
     */
    public Pic selectPicById(Long id){
        return picMapper.selectPicById(id);
    }

    /**
     * 查询图片信息列表
     *
     * @param pic 图片信息
     * @return 图片信息
     */
    @Override
    public List<Pic> selectPicList(Pic pic)
    {
        return picMapper.selectPicList(pic);
    }

    @Override
    public int deleteBy(Pic pic) {
        return picMapper.deleteBy(pic);
    }

    @Override
    public Pic getOneBy(Pic pic) {
        return picMapper.getOneBy(pic);
    }

}
