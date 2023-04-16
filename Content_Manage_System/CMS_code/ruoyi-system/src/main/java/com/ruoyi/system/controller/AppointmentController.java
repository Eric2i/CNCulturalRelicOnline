package com.ruoyi.system.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Appointment;
import com.ruoyi.system.service.IAppointmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约记录Controller
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@RestController
@RequestMapping("/system/appointment")
public class AppointmentController extends BaseController
{
    @Autowired
    private IAppointmentService appointmentService;

    /**
     * 查询预约记录列表
     */
    //@PreAuthorize("@ss.hasPermi('system:appointment:list')")
    @GetMapping("/list")
    public TableDataInfo list(Appointment appointment)
    {
        startPage();
        List<Appointment> list = appointmentService.selectAppointmentList(appointment);
        return getDataTable(list);
    }

    /**
     * 导出预约记录列表
     */
    //@PreAuthorize("@ss.hasPermi('system:appointment:export')")
    @Log(title = "预约记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Appointment appointment)
    {
        List<Appointment> list = appointmentService.selectAppointmentList(appointment);
        ExcelUtil<Appointment> util = new ExcelUtil<Appointment>(Appointment.class);
        util.exportExcel(response, list, "预约记录数据");
    }

    /**
     * 获取预约记录详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:appointment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(appointmentService.selectAppointmentById(id));
    }

    /**
     * 新增预约记录
     */
    @Log(title = "预约记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Appointment appointment)
    {
        appointment.setUserId(SecurityUtils.getUserId());
        appointment.setUsername(SecurityUtils.getUsername());
        return toAjax(appointmentService.save(appointment));
    }

    /**
     * 修改预约记录
     */
    //@PreAuthorize("@ss.hasPermi('system:appointment:edit')")
    @Log(title = "预约记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Appointment appointment)
    {
        return toAjax(appointmentService.updateById(appointment));
    }

    @DeleteMapping("/deleteBy")
    public AjaxResult deleteBy(@RequestBody Appointment appointment) {
        return toAjax(appointmentService.deleteBy(appointment));
    }

    /**
     * 删除预约记录
     */
    //@PreAuthorize("@ss.hasPermi('system:appointment:remove')")
    @Log(title = "预约记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(appointmentService.removeByIds(Arrays.asList(ids)));
    }
}
