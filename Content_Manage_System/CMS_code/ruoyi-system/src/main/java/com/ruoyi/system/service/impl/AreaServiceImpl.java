package com.ruoyi.system.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.ruoyi.system.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AreaMapper;
import com.ruoyi.system.domain.Area;
import com.ruoyi.system.service.IAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 场地信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService {
    @Resource
    private AreaMapper areaMapper;
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询场地信息
     *
     * @param id 场地信息主键
     * @return 场地信息
     */
    public Area selectAreaById(Long id){
        Area a = areaMapper.selectAreaById(id);
        a.setCategory(categoryService.selectCategoryById(a.getCategoryId()));
        return a;
    }

    /**
     * 查询场地信息列表
     *
     * @param area 场地信息
     * @return 场地信息
     */
    @Override
    public List<Area> selectAreaList(Area area)
    {
        List<Area> areas = areaMapper.selectAreaList(area);
        for (Area a : areas) {
            a.setCategory(categoryService.selectCategoryById(a.getCategoryId()));
        }
        return areas;
    }

    @Override
    public int deleteBy(Area area) {
        return areaMapper.deleteBy(area);
    }

    @Override
    public Area getOneBy(Area area) {
        return areaMapper.getOneBy(area);
    }

}
