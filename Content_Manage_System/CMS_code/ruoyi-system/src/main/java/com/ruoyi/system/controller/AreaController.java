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
import com.ruoyi.system.domain.Area;
import com.ruoyi.system.service.IAreaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 场地信息Controller
 *
 * @author ruoyi
 * @date 2023-04-10
 */
@RestController
@RequestMapping("/system/area")
public class AreaController extends BaseController
{
    @Autowired
    private IAreaService areaService;

    /**
     * 查询场地信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:area:list')")
    @GetMapping("/list")
    public TableDataInfo list(Area area)
    {
        startPage();
        List<Area> list = areaService.selectAreaList(area);
        return getDataTable(list);
    }

    /**
     * 导出场地信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:area:export')")
    @Log(title = "场地信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Area area)
    {
        List<Area> list = areaService.selectAreaList(area);
        ExcelUtil<Area> util = new ExcelUtil<Area>(Area.class);
        util.exportExcel(response, list, "场地信息数据");
    }

    /**
     * 获取场地信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:area:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(areaService.selectAreaById(id));
    }

    /**
     * 新增场地信息
     */
    @Log(title = "场地信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Area area)
    {
        return toAjax(areaService.save(area));
    }

    /**
     * 修改场地信息
     */
    //@PreAuthorize("@ss.hasPermi('system:area:edit')")
    @Log(title = "场地信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Area area)
    {
        return toAjax(areaService.updateById(area));
    }

    @DeleteMapping("/deleteBy")
    public AjaxResult deleteBy(@RequestBody Area area) {
        return toAjax(areaService.deleteBy(area));
    }

    /**
     * 删除场地信息
     */
    //@PreAuthorize("@ss.hasPermi('system:area:remove')")
    @Log(title = "场地信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(areaService.removeByIds(Arrays.asList(ids)));
    }
}
