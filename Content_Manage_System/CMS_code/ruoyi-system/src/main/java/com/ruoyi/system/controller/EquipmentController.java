package com.ruoyi.system.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.system.domain.Equipment;
import com.ruoyi.system.service.IEquipmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 器材信息Controller
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@RestController
@RequestMapping("/system/equipment")
public class EquipmentController extends BaseController
{
    @Autowired
    private IEquipmentService equipmentService;

    /**
     * 查询器材信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:equipment:list')")
    @GetMapping("/list")
    public TableDataInfo list(Equipment equipment)
    {
        startPage();
        List<Equipment> list = equipmentService.selectEquipmentList(equipment);
        return getDataTable(list);
    }

    /**
     * 导出器材信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:equipment:export')")
    @Log(title = "器材信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Equipment equipment)
    {
        List<Equipment> list = equipmentService.selectEquipmentList(equipment);
        ExcelUtil<Equipment> util = new ExcelUtil<Equipment>(Equipment.class);
        util.exportExcel(response, list, "器材信息数据");
    }

    /**
     * 获取器材信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:equipment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(equipmentService.selectEquipmentById(id));
    }

    /**
     * 新增器材信息
     */
    @Log(title = "器材信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Equipment equipment)
    {
        return toAjax(equipmentService.save(equipment));
    }

    /**
     * 修改器材信息
     */
    //@PreAuthorize("@ss.hasPermi('system:equipment:edit')")
    @Log(title = "器材信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Equipment equipment)
    {
        return toAjax(equipmentService.updateById(equipment));
    }

    @DeleteMapping("/deleteBy")
    public AjaxResult deleteBy(@RequestBody Equipment equipment) {
        return toAjax(equipmentService.deleteBy(equipment));
    }

    /**
     * 删除器材信息
     */
    //@PreAuthorize("@ss.hasPermi('system:equipment:remove')")
    @Log(title = "器材信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(equipmentService.removeByIds(Arrays.asList(ids)));
    }
}
