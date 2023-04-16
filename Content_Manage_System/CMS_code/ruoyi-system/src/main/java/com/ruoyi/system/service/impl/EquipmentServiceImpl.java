package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;

import com.ruoyi.system.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.EquipmentMapper;
import com.ruoyi.system.domain.Equipment;
import com.ruoyi.system.service.IEquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 器材信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment> implements IEquipmentService {
    @Resource
    private EquipmentMapper equipmentMapper;
    @Autowired
    private ICategoryService categoryService;

    /**
     * 查询器材信息
     *
     * @param id 器材信息主键
     * @return 器材信息
     */
    public Equipment selectEquipmentById(Long id){
        Equipment a = equipmentMapper.selectEquipmentById(id);
        a.setCategory(categoryService.selectCategoryById(a.getCategoryId()));
        return a;
    }

    /**
     * 查询器材信息列表
     *
     * @param equipment 器材信息
     * @return 器材信息
     */
    @Override
    public List<Equipment> selectEquipmentList(Equipment equipment)
    {
        List<Equipment> list = equipmentMapper.selectEquipmentList(equipment);
        for (Equipment a : list) {
            a.setCategory(categoryService.selectCategoryById(a.getCategoryId()));
        }
        return list;
    }

    @Override
    public int deleteBy(Equipment equipment) {
        return equipmentMapper.deleteBy(equipment);
    }

    @Override
    public Equipment getOneBy(Equipment equipment) {
        return equipmentMapper.getOneBy(equipment);
    }

}
