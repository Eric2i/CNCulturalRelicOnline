package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Equipment;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 器材信息Service接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface IEquipmentService extends IService<Equipment>{

    /**
     * 查询器材信息
     *
     * @param id 器材信息主键
     * @return 器材信息
     */
    public Equipment selectEquipmentById(Long id);

    /**
     * 查询器材信息列表
     *
     * @param equipment 器材信息
     * @return 器材信息集合
     */
    public List<Equipment> selectEquipmentList(Equipment equipment);

    int deleteBy(Equipment equipment);

    Equipment getOneBy(Equipment equipment);
}
