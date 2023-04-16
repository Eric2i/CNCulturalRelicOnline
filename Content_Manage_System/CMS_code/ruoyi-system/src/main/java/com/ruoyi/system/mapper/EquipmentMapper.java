package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Equipment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 器材信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface EquipmentMapper extends BaseMapper<Equipment> {

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
