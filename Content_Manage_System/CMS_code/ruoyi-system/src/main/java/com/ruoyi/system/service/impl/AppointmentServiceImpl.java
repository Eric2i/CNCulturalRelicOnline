package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AppointmentMapper;
import com.ruoyi.system.domain.Appointment;
import com.ruoyi.system.service.IAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 预约记录Service业务层处理
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements IAppointmentService {
    @Resource
    private AppointmentMapper appointmentMapper;

    /**
     * 查询预约记录
     *
     * @param id 预约记录主键
     * @return 预约记录
     */
    public Appointment selectAppointmentById(Long id){
        return appointmentMapper.selectAppointmentById(id);
    }

    /**
     * 查询预约记录列表
     *
     * @param appointment 预约记录
     * @return 预约记录
     */
    @Override
    public List<Appointment> selectAppointmentList(Appointment appointment)
    {
        return appointmentMapper.selectAppointmentList(appointment);
    }

    @Override
    public int deleteBy(Appointment appointment) {
        return appointmentMapper.deleteBy(appointment);
    }

    @Override
    public Appointment getOneBy(Appointment appointment) {
        return appointmentMapper.getOneBy(appointment);
    }

}
