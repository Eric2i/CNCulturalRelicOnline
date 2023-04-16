package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Area;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 场地信息Service接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface IAreaService extends IService<Area>{

    /**
     * 查询场地信息
     *
     * @param id 场地信息主键
     * @return 场地信息
     */
    public Area selectAreaById(Long id);

    /**
     * 查询场地信息列表
     *
     * @param area 场地信息
     * @return 场地信息集合
     */
    public List<Area> selectAreaList(Area area);

    int deleteBy(Area area);

    Area getOneBy(Area area);
}
