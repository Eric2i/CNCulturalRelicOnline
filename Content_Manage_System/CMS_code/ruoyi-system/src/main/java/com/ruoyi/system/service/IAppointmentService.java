package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Appointment;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 预约记录Service接口
 *
 * @author ruoyi
 * @date 2023-04-10
 */
public interface IAppointmentService extends IService<Appointment>{

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
