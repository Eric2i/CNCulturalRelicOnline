package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Appointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 预约记录Mapper接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface AppointmentMapper extends BaseMapper<Appointment> {

    /**
     * 查询预约记录
     *
     * @param id 预约记录主键
     * @return 预约记录
     */
    public Appointment selectAppointmentById(Long id);

    /**
     * 查询预约记录列表
     *
     * @param appointment 预约记录
     * @return 预约记录集合
     */
    public List<Appointment> selectAppointmentList(Appointment appointment);


    int deleteBy(Appointment appointment);

    Appointment getOneBy(Appointment appointment);

}
